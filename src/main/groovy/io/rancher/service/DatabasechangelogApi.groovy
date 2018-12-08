package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Databasechangelog
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface DatabasechangelogApi {
  @GET('v2-beta/databasechangelogs')
  Call<TypeCollection<Databasechangelog>> list()

  @GET('v2-beta/databasechangelogs')
  Call<TypeCollection<Databasechangelog>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/databasechangelogs/{id}')
  Call<Databasechangelog> findById(@Path('id') String id)

  @DELETE('v2-beta/databasechangelogs/{id}')
  Call<Databasechangelog> delete(@Path('id') String id)

}
