package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Catalog
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface CatalogApi {
  @GET('v1-catalog/catalogs')
  Call<TypeCollection<Catalog>> list()

  @GET('v1-catalog/catalogs')
  Call<TypeCollection<Catalog>> query(@QueryMap Map<String, String> filters)

  @GET('v1-catalog/catalogs/{id}')
  Call<Catalog> findById(@Path('id') String id)

}
