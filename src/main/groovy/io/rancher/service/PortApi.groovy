package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Port
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PortApi {
  @GET('v2-beta/ports')
  Call<TypeCollection<Port>> list()

  @GET('v2-beta/ports')
  Call<TypeCollection<Port>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/ports/{id}')
  Call<Port> findById(@Path('id') String id)

  @POST('v2-beta/ports/{id}?action=activate')
  Call<Port> activate(@Path('id') String id)

  @POST('v2-beta/ports/{id}?action=purge')
  Call<Port> purge(@Path('id') String id)

  @POST('v2-beta/ports/{id}?action=remove')
  Call<Port> remove(@Path('id') String id)

  @POST('v2-beta/ports/{id}?action=deactivate')
  Call<Port> deactivate(@Path('id') String id)
}
