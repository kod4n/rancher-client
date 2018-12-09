package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ImageApi {
  @GET('v2-beta/images')
  Call<TypeCollection<Image>> list()

  @GET('v2-beta/images')
  Call<TypeCollection<Image>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/images/{id}')
  Call<Image> findById(@Path('id') String id)

  @POST('v2-beta/images/{id}?action=activate')
  Call<Image> activate(@Path('id') String id)

  @POST('v2-beta/images/{id}?action=purge')
  Call<Image> purge(@Path('id') String id)

  @POST('v2-beta/images/{id}?action=remove')
  Call<Image> remove(@Path('id') String id)

  @POST('v2-beta/images/{id}?action=deactivate')
  Call<Image> deactivate(@Path('id') String id)
}
