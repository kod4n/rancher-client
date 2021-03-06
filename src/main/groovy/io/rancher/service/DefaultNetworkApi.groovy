package io.rancher.service

import io.rancher.type.DefaultNetwork
import io.rancher.type.Network
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DefaultNetworkApi {

  @GET('v2-beta/defaultNetworks/{id}')
  Call<DefaultNetwork> findById(@Path('id') String id)

  @POST('v2-beta/defaultNetworks/{id}?action=activate')
  Call<Network> activate(@Path('id') String id)

  @POST('v2-beta/defaultNetworks/{id}?action=purge')
  Call<Network> purge(@Path('id') String id)

  @POST('v2-beta/defaultNetworks/{id}?action=remove')
  Call<Network> remove(@Path('id') String id)

  @POST('v2-beta/defaultNetworks/{id}?action=deactivate')
  Call<Network> deactivate(@Path('id') String id)
}
