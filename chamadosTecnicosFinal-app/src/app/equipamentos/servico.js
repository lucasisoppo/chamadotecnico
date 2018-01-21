import AbstractCrudService from "../abstract.crud.service";

export default class EquipamentoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/chamadosTecnicosFinal-web/api/equipamentos')
  }

}

EquipamentoServico.$inject = ['$http']
