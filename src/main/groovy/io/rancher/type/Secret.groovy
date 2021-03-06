package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Secret extends RancherType {
  String accountId
  String created
  Map<String, Object> data
  String description
  String kind
  String name
  String removeTime
  String removed
  String state
  String uuid
  String value
  String transitioning
  String transitioningMessage
  BigInteger transitioningProgress
}
