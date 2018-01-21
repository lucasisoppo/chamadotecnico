import ListController from './list.controller'
import FormController from './form.controller'

import EquipamentoServico from './servico'

export const equipamentoConfig = (modulo) => {

  modulo.service('EquipamentoServico', EquipamentoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('equipamento', {
        template: require('@views/default.html'),
        url: '/equipamentos',
        onEnter: ['$state', function($state) {
          $state.go('equipamento.list')
        }]
      })
      .state('equipamento.list', {
        template: require('@views/equipamentos/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('equipamento.new', {
        template: require('@views/equipamentos/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('equipamento.edit', {
        template: require('@views/equipamentos/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
