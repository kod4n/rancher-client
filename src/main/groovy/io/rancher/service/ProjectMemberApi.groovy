package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProjectMember
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProjectMemberApi {
  @GET('v2-beta/projectMembers')
  Call<TypeCollection<ProjectMember>> list()

  @GET('v2-beta/projectMembers')
  Call<TypeCollection<ProjectMember>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/projectMembers')
  Call<ProjectMember> create(@Body ProjectMember projectMember)

  @GET('v2-beta/projectMembers/{id}')
  Call<ProjectMember> findById(@Path('id') String id)

  @POST('v2-beta/projectMembers/{id}?action=activate')
  Call<ProjectMember> activate(@Path('id') String id)

  @POST('v2-beta/projectMembers/{id}?action=purge')
  Call<ProjectMember> purge(@Path('id') String id)

  @POST('v2-beta/projectMembers/{id}?action=remove')
  Call<ProjectMember> remove(@Path('id') String id)

  @POST('v2-beta/projectMembers/{id}?action=deactivate')
  Call<ProjectMember> deactivate(@Path('id') String id)
}
