package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ExternalHandlerProcessConfig extends RancherType {
  String name
  String onError
}
