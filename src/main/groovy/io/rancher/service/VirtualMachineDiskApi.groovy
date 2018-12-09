package io.rancher.service

import io.rancher.type.VirtualMachineDisk
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VirtualMachineDiskApi {

  @GET('v2-beta/virtualMachineDisks/{id}')
  Call<VirtualMachineDisk> findById(@Path('id') String id)
}
