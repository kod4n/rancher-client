package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ActiveSetting extends RancherType {
  Boolean inDb
  String name
  String source
  String value
  Map<String, Object> activeValue
}
