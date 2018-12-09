package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Identity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface IdentityApi {
  @GET('v2-beta/identities')
  Call<TypeCollection<Identity>> list()

  @GET('v2-beta/identities')
  Call<TypeCollection<Identity>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/identities/{id}')
  Call<Identity> findById(@Path('id') String id)
}
