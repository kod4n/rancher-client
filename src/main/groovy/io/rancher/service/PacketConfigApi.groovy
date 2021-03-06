package io.rancher.service

import io.rancher.type.PacketConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PacketConfigApi {

  @POST('v2-beta/packetConfigs')
  Call<PacketConfig> create(@Body PacketConfig packetConfig)

  @GET('v2-beta/packetConfigs/{id}')
  Call<PacketConfig> findById(@Path('id') String id)
}
