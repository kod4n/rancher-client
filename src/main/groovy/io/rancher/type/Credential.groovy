package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Credential extends RancherType {
  String accountId
  String created
  Map<String, Object> data
  String description
  String kind
  String name
  String publicValue
  String removeTime
  String removed
  Password secretValue
  String state
  String uuid
  String transitioning
  String transitioningMessage
  BigInteger transitioningProgress
}
