import AbstractCrudService from "../abstract.crud.service";

export default class ChamadoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/chamadosTecnicosFinal-web/api/chamados')
  }

}

ChamadoServico.$inject = ['$http']
