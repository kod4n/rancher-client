package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Subnet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface SubnetApi {
  @GET('v2-beta/subnets')
  Call<TypeCollection<Subnet>> list()

  @GET('v2-beta/subnets')
  Call<TypeCollection<Subnet>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/subnets/{id}')
  Call<Subnet> findById(@Path('id') String id)

  @POST('v2-beta/subnets/{id}?action=activate')
  Call<Subnet> activate(@Path('id') String id)

  @POST('v2-beta/subnets/{id}?action=purge')
  Call<Subnet> purge(@Path('id') String id)

  @POST('v2-beta/subnets/{id}?action=remove')
  Call<Subnet> remove(@Path('id') String id)

  @POST('v2-beta/subnets/{id}?action=deactivate')
  Call<Subnet> deactivate(@Path('id') String id)
}
