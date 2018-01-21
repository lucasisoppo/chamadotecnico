import AbstractCrudService from "../abstract.crud.service";

export default class TecnicoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/chamadosTecnicosFinal-web/api/tecnicos')
  }

}

TecnicoServico.$inject = ['$http']
