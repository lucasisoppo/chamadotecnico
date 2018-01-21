import ListController from './list.controller'
import FormController from './form.controller'

import TecnicoServico from './servico'

export const tecnicoConfig = (modulo) => {

  modulo.service('TecnicoServico', TecnicoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('tecnico', {
        template: require('@views/default.html'),
        url: '/tecnicos',
        onEnter: ['$state', function($state) {
          $state.go('tecnico.list')
        }]
      })
      .state('tecnico.list', {
        template: require('@views/tecnicos/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('tecnico.new', {
        template: require('@views/tecnicos/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('tecnico.edit', {
        template: require('@views/tecnicos/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
