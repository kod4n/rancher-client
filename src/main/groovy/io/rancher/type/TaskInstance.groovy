package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class TaskInstance extends RancherType {
  String endTime
  String exception
  String name
  String serverId
  String startTime
  String taskId
}
