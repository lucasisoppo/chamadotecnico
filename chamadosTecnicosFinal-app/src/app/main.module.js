import * as angular from 'angular'

import { default as uiRouter } from '@uirouter/angularjs'
import { default as uiNotification } from 'angular-ui-notification'
import { default as inputMasks } from 'angular-input-masks'
import { mainConfig } from './main/config'
import { clienteConfig } from './clientes/config'
import { equipamentoConfig } from './equipamentos/config'
import { tecnicoConfig } from './tecnicos/config'
import { chamadoConfig } from './chamados/config'

require('angular-i18n/angular-locale_pt-br.js')

export const appModule = 'app'

var modulo = angular.module(appModule, [uiRouter, uiNotification, inputMasks])

modulo.config(mainConfig(modulo))
      .config(clienteConfig(modulo))
      .config(equipamentoConfig(modulo))
      .config(tecnicoConfig(modulo))
      .config(chamadoConfig(modulo))
