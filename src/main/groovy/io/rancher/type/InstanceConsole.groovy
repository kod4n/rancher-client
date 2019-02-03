package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class InstanceConsole extends RancherType {
  String url
  String kind
  String password
}
