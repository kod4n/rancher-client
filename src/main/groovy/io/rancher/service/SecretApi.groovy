package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Secret
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface SecretApi {
  @GET('v2-beta/secrets')
  Call<TypeCollection<Secret>> list()

  @GET('v2-beta/secrets')
  Call<TypeCollection<Secret>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/secrets/{id}')
  Call<Secret> findById(@Path('id') String id)

  @POST('v2-beta/secrets/{id}?action=remove')
  Call<Secret> remove(@Path('id') String id)

}
