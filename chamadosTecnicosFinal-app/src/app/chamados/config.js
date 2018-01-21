import ListController from './list.controller'
import FormController from './form.controller'

import ChamadoServico from './servico'

export const chamadoConfig = (modulo) => {

  modulo.service('ChamadoServico', ChamadoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('chamado', {
        template: require('@views/default.html'),
        url: '/chamados',
        onEnter: ['$state', function($state) {
          $state.go('chamado.list')
        }]
      })
      .state('chamado.list', {
        template: require('@views/chamados/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('chamado.new', {
        template: require('@views/chamados/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('chamado.edit', {
        template: require('@views/chamados/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
