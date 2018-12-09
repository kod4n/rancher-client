package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProjectTemplate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProjectTemplateApi {
  @GET('v2-beta/projectTemplates')
  Call<TypeCollection<ProjectTemplate>> list()

  @GET('v2-beta/projectTemplates')
  Call<TypeCollection<ProjectTemplate>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/projectTemplates')
  Call<ProjectTemplate> create(@Body ProjectTemplate projectTemplate)

  @GET('v2-beta/projectTemplates/{id}')
  Call<ProjectTemplate> findById(@Path('id') String id)

  @PUT('v2-beta/projectTemplates/{id}')
  Call<ProjectTemplate> update(@Path('id') String id, @Body ProjectTemplate projectTemplate)

  @DELETE('v2-beta/projectTemplates/{id}')
  Call<ProjectTemplate> delete(@Path('id') String id)

  @POST('v2-beta/projectTemplates/{id}?action=remove')
  Call<ProjectTemplate> remove(@Path('id') String id)
}
