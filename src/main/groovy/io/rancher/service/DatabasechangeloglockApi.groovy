package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Databasechangeloglock
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface DatabasechangeloglockApi {
  @GET('v2-beta/databasechangeloglocks')
  Call<TypeCollection<Databasechangeloglock>> list()

  @GET('v2-beta/databasechangeloglocks')
  Call<TypeCollection<Databasechangeloglock>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/databasechangeloglocks/{id}')
  Call<Databasechangeloglock> findById(@Path('id') String id)

  @DELETE('v2-beta/databasechangeloglocks/{id}')
  Call<Databasechangeloglock> delete(@Path('id') String id)
}
