package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.AuditLog
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface AuditLogApi {
  @GET('v2-beta/auditLogs')
  Call<TypeCollection<AuditLog>> list()

  @GET('v2-beta/auditLogs')
  Call<TypeCollection<AuditLog>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/auditLogs/{id}')
  Call<AuditLog> findById(@Path('id') String id)

}
