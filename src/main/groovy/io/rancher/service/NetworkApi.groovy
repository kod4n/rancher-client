package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Network
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface NetworkApi {
  @GET('v2-beta/networks')
  Call<TypeCollection<Network>> list()

  @GET('v2-beta/networks')
  Call<TypeCollection<Network>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/networks/{id}')
  Call<Network> findById(@Path('id') String id)

  @POST('v2-beta/networks/{id}?action=activate')
  Call<Network> activate(@Path('id') String id)

  @POST('v2-beta/networks/{id}?action=purge')
  Call<Network> purge(@Path('id') String id)

  @POST('v2-beta/networks/{id}?action=remove')
  Call<Network> remove(@Path('id') String id)

  @POST('v2-beta/networks/{id}?action=deactivate')
  Call<Network> deactivate(@Path('id') String id)
}
