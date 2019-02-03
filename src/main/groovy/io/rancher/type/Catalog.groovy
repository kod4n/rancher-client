package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Catalog extends RancherType {
  Map<String, Object> actions
  String branch
  String commit
  String environmentId
  String kind
  Map<String, Object> links
  String name
  String type
  String url
}
