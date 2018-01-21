export default class FormController {
    
        constructor($stateParams, $state, ChamadoServico, ClienteServico, Notification) {
            this.record = {}
            this.title = 'Adicionando registro'
            this._service = ChamadoServico
            if ($stateParams.id) {
                this.title = 'Editando registro'
                this._service.findById($stateParams.id)
                    .then(data => {
                        this.record = data
                        this.record.emissao = new Date(this.record.emissao)
                        console.log(this.record)
                    })
            }
            this._state = $state
            this._notify = Notification
            this.clientes = []
            ClienteServico.findAll()
                .then(data => {
                    this.clientes = data
                    console.log(data)
                }, erro => {
                    this._notify.error('Erro ao carregar os clientes!')
                })

        }
    
        save() {
            this._service.save(this.record)
                .then(resp => {
                    this._notify.success('Registro salvo com sucesso!')
                    this._state.go('chamado.list')
                }).catch(erro => {
                    this._notify.error('Erro ao salvar o registro!')
                })
        }
    }
    
    FormController.$inject = ['$stateParams', '$state', 'ChamadoServico', 'ClienteServico', 'Notification']
    