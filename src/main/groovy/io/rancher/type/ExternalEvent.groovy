package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ExternalEvent extends RancherType {
  String accountId
  String created
  Map<String, Object> data
  String eventType
  String externalId
  String kind
  String reportedAccountId
  String state
  String uuid
  String transitioning
  String transitioningMessage
  BigInteger transitioningProgress
}
