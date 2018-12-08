package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Project
import io.rancher.type.Account
import io.rancher.type.SetProjectMembersInput
import io.rancher.type.ActiveSetting
import io.rancher.type.AddOutputsInput
import io.rancher.type.AddRemoveServiceLinkInput
import io.rancher.type.Amazonec2Config
import io.rancher.type.ApiKey
import io.rancher.type.AuditLog
import io.rancher.type.AzureConfig
import io.rancher.type.Backup
import io.rancher.type.BackupTarget
import io.rancher.type.BaseMachineConfig
import io.rancher.type.Binding
import io.rancher.type.BlkioDeviceOption
import io.rancher.type.CatalogTemplate
import io.rancher.type.Certificate
import io.rancher.type.ChangeSecretInput
import io.rancher.type.ComposeConfig
import io.rancher.type.ComposeConfigInput
import io.rancher.type.ComposeProject
import io.rancher.type.ComposeService
import io.rancher.type.Container
import io.rancher.type.ContainerEvent
import io.rancher.type.ContainerExec
import io.rancher.type.ContainerLogs
import io.rancher.type.ContainerProxy
import io.rancher.type.Credential
import io.rancher.type.DefaultNetwork
import io.rancher.type.DigitaloceanConfig
import io.rancher.type.DnsService
import io.rancher.type.DockerBuild
import io.rancher.type.ExternalDnsEvent
import io.rancher.type.ExternalEvent
import io.rancher.type.ExternalHostEvent
import io.rancher.type.ExternalService
import io.rancher.type.ExternalServiceEvent
import io.rancher.type.ExternalStoragePoolEvent
import io.rancher.type.ExternalVolumeEvent
import io.rancher.type.FieldDocumentation
import io.rancher.type.GenericObject
import io.rancher.type.HealthcheckInstanceHostMap
import io.rancher.type.Host
import io.rancher.type.HostAccess
import io.rancher.type.HostTemplate
import io.rancher.type.Identity
import io.rancher.type.Image
import io.rancher.type.InServiceUpgradeStrategy
import io.rancher.type.Instance
import io.rancher.type.InstanceConsole
import io.rancher.type.InstanceConsoleInput
import io.rancher.type.InstanceHealthCheck
import io.rancher.type.InstanceLink
import io.rancher.type.InstanceStop
import io.rancher.type.IpAddress
import io.rancher.type.KubernetesService
import io.rancher.type.KubernetesStack
import io.rancher.type.KubernetesStackUpgrade
import io.rancher.type.Label
import io.rancher.type.LaunchConfig
import io.rancher.type.LbConfig
import io.rancher.type.LbTargetConfig
import io.rancher.type.LoadBalancerCookieStickinessPolicy
import io.rancher.type.LoadBalancerService
import io.rancher.type.LogConfig
import io.rancher.type.Machine
import io.rancher.type.MachineDriver
import io.rancher.type.Mount
import io.rancher.type.MountEntry
import io.rancher.type.Network
import io.rancher.type.NetworkDriver
import io.rancher.type.NetworkDriverService
import io.rancher.type.NetworkPolicyRule
import io.rancher.type.NetworkPolicyRuleBetween
import io.rancher.type.NetworkPolicyRuleMember
import io.rancher.type.NetworkPolicyRuleWithin
import io.rancher.type.NfsConfig
import io.rancher.type.PacketConfig
import io.rancher.type.Password
import io.rancher.type.PhysicalHost
import io.rancher.type.Port
import io.rancher.type.PortRule
import io.rancher.type.ProjectMember
import io.rancher.type.ProjectTemplate
import io.rancher.type.PublicEndpoint
import io.rancher.type.PullTask
import io.rancher.type.RecreateOnQuorumStrategyConfig
import io.rancher.type.Region
import io.rancher.type.Register
import io.rancher.type.RegistrationToken
import io.rancher.type.Registry
import io.rancher.type.RegistryCredential
import io.rancher.type.RestartPolicy
import io.rancher.type.RestoreFromBackupInput
import io.rancher.type.RevertToSnapshotInput
import io.rancher.type.RollingRestartStrategy
import io.rancher.type.ScalePolicy
import io.rancher.type.ScheduledUpgrade
import io.rancher.type.SecondaryLaunchConfig
import io.rancher.type.Secret
import io.rancher.type.SecretReference
import io.rancher.type.Service
import io.rancher.type.ServiceBinding
import io.rancher.type.ServiceConsumeMap
import io.rancher.type.ServiceEvent
import io.rancher.type.ServiceExposeMap
import io.rancher.type.ServiceLink
import io.rancher.type.ServiceLog
import io.rancher.type.ServiceProxy
import io.rancher.type.ServiceRestart
import io.rancher.type.ServiceUpgrade
import io.rancher.type.ServiceUpgradeStrategy
import io.rancher.type.ServicesPortRange
import io.rancher.type.SetServiceLinksInput
import io.rancher.type.Setting
import io.rancher.type.Snapshot
import io.rancher.type.SnapshotBackupInput
import io.rancher.type.Stack
import io.rancher.type.StackUpgrade
import io.rancher.type.StatsAccess
import io.rancher.type.StorageDriver
import io.rancher.type.StorageDriverService
import io.rancher.type.StoragePool
import io.rancher.type.Subnet
import io.rancher.type.TargetPortRule
import io.rancher.type.ToServiceUpgradeStrategy
import io.rancher.type.TypeDocumentation
import io.rancher.type.Ulimit
import io.rancher.type.VirtualMachine
import io.rancher.type.VirtualMachineDisk
import io.rancher.type.Volume
import io.rancher.type.VolumeActivateInput
import io.rancher.type.VolumeSnapshotInput
import io.rancher.type.VolumeTemplate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProjectApi {
  @GET('v2-beta/projects')
  Call<TypeCollection<Project>> list()

  @GET('v2-beta/projects')
  Call<TypeCollection<Project>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/projects')
  Call<Project> create(@Body Project project)

  @GET('v2-beta/projects/{id}')
  Call<Project> findById(@Path('id') String id)

  @PUT('v2-beta/projects/{id}')
  Call<Project> update(@Path('id') String id, @Body Project project)

  @DELETE('v2-beta/projects/{id}')
  Call<Project> delete(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=upgrade')
  Call<Account> upgrade(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=activate')
  Call<Account> activate(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=purge')
  Call<Account> purge(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=remove')
  Call<Account> remove(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=deactivate')
  Call<Account> deactivate(@Path('id') String id)

  @POST('v2-beta/projects/{id}?action=setmembers')
  Call<SetProjectMembersInput> setmembers(@Path('id') String id, @Body SetProjectMembersInput setProjectMembersInput)

  @GET('v2-beta/projects/{projectId}/account')
  Call<TypeCollection<Account>> listaccounts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/account')
  Call<TypeCollection<Account>> queryaccounts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/account/{id}')
  Call<Account> findAccountById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/account/{id}?action=upgrade')
  Call<Account> upgradeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/account/{id}?action=activate')
  Call<Account> activateAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/account/{id}?action=purge')
  Call<Account> purgeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/account/{id}?action=remove')
  Call<Account> removeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/account/{id}?action=deactivate')
  Call<Account> deactivateAccount(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/activeSetting/{id}')
  Call<ActiveSetting> findActiveSettingById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/addOutputsInput/{id}')
  Call<AddOutputsInput> findAddOutputsInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/addRemoveServiceLinkInput')
  Call<AddRemoveServiceLinkInput> createAddRemoveServiceLinkInput(@Path('projectId') String projectId, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @GET('v2-beta/projects/{projectId}/addRemoveServiceLinkInput/{id}')
  Call<AddRemoveServiceLinkInput> findAddRemoveServiceLinkInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/amazonec2Config')
  Call<Amazonec2Config> createAmazonec2Config(@Path('projectId') String projectId, @Body Amazonec2Config amazonec2Config)

  @GET('v2-beta/projects/{projectId}/amazonec2Config/{id}')
  Call<Amazonec2Config> findAmazonec2ConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/apiKey')
  Call<TypeCollection<ApiKey>> listapiKeys(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/apiKey')
  Call<TypeCollection<ApiKey>> queryapiKeys(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/apiKey')
  Call<ApiKey> createApiKey(@Path('projectId') String projectId, @Body ApiKey apiKey)

  @GET('v2-beta/projects/{projectId}/apiKey/{id}')
  Call<ApiKey> findApiKeyById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/apiKey/{id}')
  Call<ApiKey> updateApiKey(@Path('projectId') String projectId, @Path('id') String id, @Body ApiKey apiKey)

  @DELETE('v2-beta/projects/{projectId}/apiKey/{id}')
  Call<ApiKey> deleteApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKey/{id}?action=activate')
  Call<Credential> activateApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKey/{id}?action=purge')
  Call<Credential> purgeApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKey/{id}?action=remove')
  Call<Credential> removeApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKey/{id}?action=deactivate')
  Call<Credential> deactivateApiKey(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/auditLog')
  Call<TypeCollection<AuditLog>> listauditLogs(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/auditLog')
  Call<TypeCollection<AuditLog>> queryauditLogs(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/auditLog/{id}')
  Call<AuditLog> findAuditLogById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/azureConfig')
  Call<AzureConfig> createAzureConfig(@Path('projectId') String projectId, @Body AzureConfig azureConfig)

  @GET('v2-beta/projects/{projectId}/azureConfig/{id}')
  Call<AzureConfig> findAzureConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/backup')
  Call<TypeCollection<Backup>> listbackups(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/backup')
  Call<TypeCollection<Backup>> querybackups(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/backup/{id}')
  Call<Backup> findBackupById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/backup/{id}')
  Call<Backup> deleteBackup(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/backup/{id}?action=remove')
  Call<Backup> removeBackup(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/backupTarget')
  Call<TypeCollection<BackupTarget>> listbackupTargets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/backupTarget')
  Call<TypeCollection<BackupTarget>> querybackupTargets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/backupTarget')
  Call<BackupTarget> createBackupTarget(@Path('projectId') String projectId, @Body BackupTarget backupTarget)

  @GET('v2-beta/projects/{projectId}/backupTarget/{id}')
  Call<BackupTarget> findBackupTargetById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/backupTarget/{id}')
  Call<BackupTarget> deleteBackupTarget(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/backupTarget/{id}?action=remove')
  Call<BackupTarget> removeBackupTarget(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/baseMachineConfig/{id}')
  Call<BaseMachineConfig> findBaseMachineConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/binding')
  Call<Binding> createBinding(@Path('projectId') String projectId, @Body Binding binding)

  @GET('v2-beta/projects/{projectId}/binding/{id}')
  Call<Binding> findBindingById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/binding/{id}')
  Call<Binding> updateBinding(@Path('projectId') String projectId, @Path('id') String id, @Body Binding binding)

  @POST('v2-beta/projects/{projectId}/blkioDeviceOption')
  Call<BlkioDeviceOption> createBlkioDeviceOption(@Path('projectId') String projectId, @Body BlkioDeviceOption blkioDeviceOption)

  @GET('v2-beta/projects/{projectId}/blkioDeviceOption/{id}')
  Call<BlkioDeviceOption> findBlkioDeviceOptionById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/catalogTemplate/{id}')
  Call<CatalogTemplate> findCatalogTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/certificate')
  Call<TypeCollection<Certificate>> listcertificates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/certificate')
  Call<TypeCollection<Certificate>> querycertificates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/certificate')
  Call<Certificate> createCertificate(@Path('projectId') String projectId, @Body Certificate certificate)

  @GET('v2-beta/projects/{projectId}/certificate/{id}')
  Call<Certificate> findCertificateById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/certificate/{id}')
  Call<Certificate> updateCertificate(@Path('projectId') String projectId, @Path('id') String id, @Body Certificate certificate)

  @DELETE('v2-beta/projects/{projectId}/certificate/{id}')
  Call<Certificate> deleteCertificate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/certificate/{id}?action=remove')
  Call<Certificate> removeCertificate(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/changeSecretInput')
  Call<ChangeSecretInput> createChangeSecretInput(@Path('projectId') String projectId, @Body ChangeSecretInput changeSecretInput)

  @GET('v2-beta/projects/{projectId}/changeSecretInput/{id}')
  Call<ChangeSecretInput> findChangeSecretInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/composeConfig/{id}')
  Call<ComposeConfig> findComposeConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeConfigInput')
  Call<ComposeConfigInput> createComposeConfigInput(@Path('projectId') String projectId, @Body ComposeConfigInput composeConfigInput)

  @GET('v2-beta/projects/{projectId}/composeConfigInput/{id}')
  Call<ComposeConfigInput> findComposeConfigInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/composeProject')
  Call<TypeCollection<ComposeProject>> listcomposeProjects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/composeProject')
  Call<TypeCollection<ComposeProject>> querycomposeProjects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/composeProject')
  Call<ComposeProject> createComposeProject(@Path('projectId') String projectId, @Body ComposeProject composeProject)

  @GET('v2-beta/projects/{projectId}/composeProject/{id}')
  Call<ComposeProject> findComposeProjectById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/composeProject/{id}')
  Call<ComposeProject> updateComposeProject(@Path('projectId') String projectId, @Path('id') String id, @Body ComposeProject composeProject)

  @DELETE('v2-beta/projects/{projectId}/composeProject/{id}')
  Call<ComposeProject> deleteComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProject/{id}?action=rollback')
  Call<Stack> rollbackComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProject/{id}?action=error')
  Call<Stack> errorComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProject/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProject/{id}?action=remove')
  Call<Stack> removeComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProject/{id}?action=finishupgrade')
  Call<Stack> finishupgradeComposeProject(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/composeService')
  Call<TypeCollection<ComposeService>> listcomposeServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/composeService')
  Call<TypeCollection<ComposeService>> querycomposeServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/composeService/{id}')
  Call<ComposeService> findComposeServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/composeService/{id}')
  Call<ComposeService> deleteComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=rollback')
  Call<Service> rollbackComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=remove')
  Call<Service> removeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=finishupgrade')
  Call<Service> finishupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=continueupgrade')
  Call<Service> continueupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=activate')
  Call<Service> activateComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/container')
  Call<TypeCollection<Container>> listcontainers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/container')
  Call<TypeCollection<Container>> querycontainers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/container')
  Call<Container> createContainer(@Path('projectId') String projectId, @Body Container container)

  @GET('v2-beta/projects/{projectId}/container/{id}')
  Call<Container> findContainerById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/container/{id}')
  Call<Container> updateContainer(@Path('projectId') String projectId, @Path('id') String id, @Body Container container)

  @DELETE('v2-beta/projects/{projectId}/container/{id}')
  Call<Container> deleteContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=console')
  Call<InstanceConsole> consoleContainer(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=restart')
  Call<Instance> restartContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=deallocate')
  Call<Instance> deallocateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=start')
  Call<Instance> startContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=purge')
  Call<Instance> purgeContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=error')
  Call<Instance> errorContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=remove')
  Call<Instance> removeContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=stop')
  Call<Instance> stopContainer(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=allocate')
  Call<Instance> allocateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=updatehealthy')
  Call<Instance> updatehealthyContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=migrate')
  Call<Instance> migrateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=logs')
  Call<HostAccess> logsContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerLogs containerLogs)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=execute')
  Call<HostAccess> executeContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/container/{id}?action=proxy')
  Call<HostAccess> proxyContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/containerEvent')
  Call<TypeCollection<ContainerEvent>> listcontainerEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/containerEvent')
  Call<TypeCollection<ContainerEvent>> querycontainerEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/containerEvent/{id}')
  Call<ContainerEvent> findContainerEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerEvent/{id}?action=remove')
  Call<ContainerEvent> removeContainerEvent(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/containerExec')
  Call<ContainerExec> createContainerExec(@Path('projectId') String projectId, @Body ContainerExec containerExec)

  @GET('v2-beta/projects/{projectId}/containerExec/{id}')
  Call<ContainerExec> findContainerExecById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerLogs')
  Call<ContainerLogs> createContainerLogs(@Path('projectId') String projectId, @Body ContainerLogs containerLogs)

  @GET('v2-beta/projects/{projectId}/containerLogs/{id}')
  Call<ContainerLogs> findContainerLogsById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerProxy')
  Call<ContainerProxy> createContainerProxy(@Path('projectId') String projectId, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/containerProxy/{id}')
  Call<ContainerProxy> findContainerProxyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/credential')
  Call<TypeCollection<Credential>> listcredentials(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/credential')
  Call<TypeCollection<Credential>> querycredentials(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/credential/{id}')
  Call<Credential> findCredentialById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credential/{id}?action=activate')
  Call<Credential> activateCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credential/{id}?action=purge')
  Call<Credential> purgeCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credential/{id}?action=remove')
  Call<Credential> removeCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credential/{id}?action=deactivate')
  Call<Credential> deactivateCredential(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/defaultNetwork/{id}')
  Call<DefaultNetwork> findDefaultNetworkById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetwork/{id}?action=activate')
  Call<Network> activateDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetwork/{id}?action=purge')
  Call<Network> purgeDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetwork/{id}?action=remove')
  Call<Network> removeDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetwork/{id}?action=deactivate')
  Call<Network> deactivateDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/digitaloceanConfig')
  Call<DigitaloceanConfig> createDigitaloceanConfig(@Path('projectId') String projectId, @Body DigitaloceanConfig digitaloceanConfig)

  @GET('v2-beta/projects/{projectId}/digitaloceanConfig/{id}')
  Call<DigitaloceanConfig> findDigitaloceanConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/dnsService')
  Call<TypeCollection<DnsService>> listdnsServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/dnsService')
  Call<TypeCollection<DnsService>> querydnsServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/dnsService')
  Call<DnsService> createDnsService(@Path('projectId') String projectId, @Body DnsService dnsService)

  @GET('v2-beta/projects/{projectId}/dnsService/{id}')
  Call<DnsService> findDnsServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/dnsService/{id}')
  Call<DnsService> updateDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body DnsService dnsService)

  @DELETE('v2-beta/projects/{projectId}/dnsService/{id}')
  Call<DnsService> deleteDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=rollback')
  Call<Service> rollbackDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=upgrade')
  Call<Service> upgradeDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=restart')
  Call<Service> restartDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=remove')
  Call<Service> removeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=deactivate')
  Call<Service> deactivateDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=finishupgrade')
  Call<Service> finishupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=removeservicelink')
  Call<Service> removeservicelinkDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=continueupgrade')
  Call<Service> continueupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=activate')
  Call<Service> activateDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=addservicelink')
  Call<Service> addservicelinkDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsService/{id}?action=setservicelinks')
  Call<Service> setservicelinksDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/dockerBuild')
  Call<DockerBuild> createDockerBuild(@Path('projectId') String projectId, @Body DockerBuild dockerBuild)

  @GET('v2-beta/projects/{projectId}/dockerBuild/{id}')
  Call<DockerBuild> findDockerBuildById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalDnsEvent')
  Call<TypeCollection<ExternalDnsEvent>> listexternalDnsEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalDnsEvent')
  Call<TypeCollection<ExternalDnsEvent>> queryexternalDnsEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalDnsEvent/{id}')
  Call<ExternalDnsEvent> findExternalDnsEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalDnsEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalDnsEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalEvent')
  Call<TypeCollection<ExternalEvent>> listexternalEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalEvent')
  Call<TypeCollection<ExternalEvent>> queryexternalEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalEvent/{id}')
  Call<ExternalEvent> findExternalEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalHostEvent')
  Call<TypeCollection<ExternalHostEvent>> listexternalHostEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalHostEvent')
  Call<TypeCollection<ExternalHostEvent>> queryexternalHostEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/externalHostEvent')
  Call<ExternalHostEvent> createExternalHostEvent(@Path('projectId') String projectId, @Body ExternalHostEvent externalHostEvent)

  @GET('v2-beta/projects/{projectId}/externalHostEvent/{id}')
  Call<ExternalHostEvent> findExternalHostEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalHostEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalHostEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalService')
  Call<TypeCollection<ExternalService>> listexternalServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalService')
  Call<TypeCollection<ExternalService>> queryexternalServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/externalService')
  Call<ExternalService> createExternalService(@Path('projectId') String projectId, @Body ExternalService externalService)

  @GET('v2-beta/projects/{projectId}/externalService/{id}')
  Call<ExternalService> findExternalServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/externalService/{id}')
  Call<ExternalService> updateExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ExternalService externalService)

  @DELETE('v2-beta/projects/{projectId}/externalService/{id}')
  Call<ExternalService> deleteExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=rollback')
  Call<Service> rollbackExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=upgrade')
  Call<Service> upgradeExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=restart')
  Call<Service> restartExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=remove')
  Call<Service> removeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=deactivate')
  Call<Service> deactivateExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=finishupgrade')
  Call<Service> finishupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=continueupgrade')
  Call<Service> continueupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=activate')
  Call<Service> activateExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalServiceEvent')
  Call<TypeCollection<ExternalServiceEvent>> listexternalServiceEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalServiceEvent')
  Call<TypeCollection<ExternalServiceEvent>> queryexternalServiceEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalServiceEvent/{id}')
  Call<ExternalServiceEvent> findExternalServiceEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServiceEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalServiceEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvent')
  Call<TypeCollection<ExternalStoragePoolEvent>> listexternalStoragePoolEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvent')
  Call<TypeCollection<ExternalStoragePoolEvent>> queryexternalStoragePoolEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvent/{id}')
  Call<ExternalStoragePoolEvent> findExternalStoragePoolEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalStoragePoolEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalStoragePoolEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/externalVolumeEvent')
  Call<TypeCollection<ExternalVolumeEvent>> listexternalVolumeEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalVolumeEvent')
  Call<TypeCollection<ExternalVolumeEvent>> queryexternalVolumeEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalVolumeEvent/{id}')
  Call<ExternalVolumeEvent> findExternalVolumeEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalVolumeEvent/{id}?action=remove')
  Call<ExternalEvent> removeExternalVolumeEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/fieldDocumentation/{id}')
  Call<FieldDocumentation> findFieldDocumentationById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/genericObject')
  Call<TypeCollection<GenericObject>> listgenericObjects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/genericObject')
  Call<TypeCollection<GenericObject>> querygenericObjects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/genericObject')
  Call<GenericObject> createGenericObject(@Path('projectId') String projectId, @Body GenericObject genericObject)

  @GET('v2-beta/projects/{projectId}/genericObject/{id}')
  Call<GenericObject> findGenericObjectById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/genericObject/{id}')
  Call<GenericObject> updateGenericObject(@Path('projectId') String projectId, @Path('id') String id, @Body GenericObject genericObject)

  @DELETE('v2-beta/projects/{projectId}/genericObject/{id}')
  Call<GenericObject> deleteGenericObject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/genericObject/{id}?action=remove')
  Call<GenericObject> removeGenericObject(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMap')
  Call<TypeCollection<HealthcheckInstanceHostMap>> listhealthcheckInstanceHostMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMap')
  Call<TypeCollection<HealthcheckInstanceHostMap>> queryhealthcheckInstanceHostMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMap/{id}')
  Call<HealthcheckInstanceHostMap> findHealthcheckInstanceHostMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/healthcheckInstanceHostMap/{id}?action=remove')
  Call<HealthcheckInstanceHostMap> removeHealthcheckInstanceHostMap(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/host')
  Call<TypeCollection<Host>> listhosts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/host')
  Call<TypeCollection<Host>> queryhosts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/host')
  Call<Host> createHost(@Path('projectId') String projectId, @Body Host host)

  @GET('v2-beta/projects/{projectId}/host/{id}')
  Call<Host> findHostById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/host/{id}')
  Call<Host> updateHost(@Path('projectId') String projectId, @Path('id') String id, @Body Host host)

  @DELETE('v2-beta/projects/{projectId}/host/{id}')
  Call<Host> deleteHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=evacuate')
  Call<Host> evacuateHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=provision')
  Call<Host> provisionHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=dockersocket')
  Call<HostAccess> dockersocketHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=activate')
  Call<Host> activateHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=purge')
  Call<Host> purgeHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=error')
  Call<Host> errorHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=remove')
  Call<Host> removeHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/host/{id}?action=deactivate')
  Call<Host> deactivateHost(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/hostAccess/{id}')
  Call<HostAccess> findHostAccessById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/hostTemplate')
  Call<TypeCollection<HostTemplate>> listhostTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/hostTemplate')
  Call<TypeCollection<HostTemplate>> queryhostTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/hostTemplate')
  Call<HostTemplate> createHostTemplate(@Path('projectId') String projectId, @Body HostTemplate hostTemplate)

  @GET('v2-beta/projects/{projectId}/hostTemplate/{id}')
  Call<HostTemplate> findHostTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/hostTemplate/{id}')
  Call<HostTemplate> updateHostTemplate(@Path('projectId') String projectId, @Path('id') String id, @Body HostTemplate hostTemplate)

  @DELETE('v2-beta/projects/{projectId}/hostTemplate/{id}')
  Call<HostTemplate> deleteHostTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hostTemplate/{id}?action=remove')
  Call<HostTemplate> removeHostTemplate(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/identity')
  Call<TypeCollection<Identity>> listidentities(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/identity')
  Call<TypeCollection<Identity>> queryidentities(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/identity/{id}')
  Call<Identity> findIdentityById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/image')
  Call<TypeCollection<Image>> listimages(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/image')
  Call<TypeCollection<Image>> queryimages(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/image/{id}')
  Call<Image> findImageById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/image/{id}?action=activate')
  Call<Image> activateImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/image/{id}?action=purge')
  Call<Image> purgeImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/image/{id}?action=remove')
  Call<Image> removeImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/image/{id}?action=deactivate')
  Call<Image> deactivateImage(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/inServiceUpgradeStrategy')
  Call<InServiceUpgradeStrategy> createInServiceUpgradeStrategy(@Path('projectId') String projectId, @Body InServiceUpgradeStrategy inServiceUpgradeStrategy)

  @GET('v2-beta/projects/{projectId}/inServiceUpgradeStrategy/{id}')
  Call<InServiceUpgradeStrategy> findInServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instance')
  Call<TypeCollection<Instance>> listinstances(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/instance')
  Call<TypeCollection<Instance>> queryinstances(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/instance/{id}')
  Call<Instance> findInstanceById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=console')
  Call<InstanceConsole> consoleInstance(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=restart')
  Call<Instance> restartInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=deallocate')
  Call<Instance> deallocateInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=start')
  Call<Instance> startInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=purge')
  Call<Instance> purgeInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=error')
  Call<Instance> errorInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=remove')
  Call<Instance> removeInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=stop')
  Call<Instance> stopInstance(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=allocate')
  Call<Instance> allocateInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=updatehealthy')
  Call<Instance> updatehealthyInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instance/{id}?action=migrate')
  Call<Instance> migrateInstance(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/instanceConsole/{id}')
  Call<InstanceConsole> findInstanceConsoleById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instanceConsoleInput/{id}')
  Call<InstanceConsoleInput> findInstanceConsoleInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceHealthCheck')
  Call<InstanceHealthCheck> createInstanceHealthCheck(@Path('projectId') String projectId, @Body InstanceHealthCheck instanceHealthCheck)

  @GET('v2-beta/projects/{projectId}/instanceHealthCheck/{id}')
  Call<InstanceHealthCheck> findInstanceHealthCheckById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instanceLink')
  Call<TypeCollection<InstanceLink>> listinstanceLinks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/instanceLink')
  Call<TypeCollection<InstanceLink>> queryinstanceLinks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/instanceLink/{id}')
  Call<InstanceLink> findInstanceLinkById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/instanceLink/{id}')
  Call<InstanceLink> updateInstanceLink(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceLink instanceLink)

  @POST('v2-beta/projects/{projectId}/instanceLink/{id}?action=activate')
  Call<InstanceLink> activateInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLink/{id}?action=purge')
  Call<InstanceLink> purgeInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLink/{id}?action=remove')
  Call<InstanceLink> removeInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLink/{id}?action=deactivate')
  Call<InstanceLink> deactivateInstanceLink(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/instanceStop')
  Call<InstanceStop> createInstanceStop(@Path('projectId') String projectId, @Body InstanceStop instanceStop)

  @GET('v2-beta/projects/{projectId}/instanceStop/{id}')
  Call<InstanceStop> findInstanceStopById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/ipAddress')
  Call<TypeCollection<IpAddress>> listipAddresses(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/ipAddress')
  Call<TypeCollection<IpAddress>> queryipAddresses(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/ipAddress/{id}')
  Call<IpAddress> findIpAddressById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=activate')
  Call<IpAddress> activateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=purge')
  Call<IpAddress> purgeIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=remove')
  Call<IpAddress> removeIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=associate')
  Call<IpAddress> associateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=deactivate')
  Call<IpAddress> deactivateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddress/{id}?action=disassociate')
  Call<IpAddress> disassociateIpAddress(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/kubernetesService')
  Call<TypeCollection<KubernetesService>> listkubernetesServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/kubernetesService')
  Call<TypeCollection<KubernetesService>> querykubernetesServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/kubernetesService/{id}')
  Call<KubernetesService> findKubernetesServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=rollback')
  Call<Service> rollbackKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=upgrade')
  Call<Service> upgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=restart')
  Call<Service> restartKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=remove')
  Call<Service> removeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=deactivate')
  Call<Service> deactivateKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=finishupgrade')
  Call<Service> finishupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=removeservicelink')
  Call<Service> removeservicelinkKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=continueupgrade')
  Call<Service> continueupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=activate')
  Call<Service> activateKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=addservicelink')
  Call<Service> addservicelinkKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesService/{id}?action=setservicelinks')
  Call<Service> setservicelinksKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/kubernetesStack')
  Call<TypeCollection<KubernetesStack>> listkubernetesStacks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/kubernetesStack')
  Call<TypeCollection<KubernetesStack>> querykubernetesStacks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/kubernetesStack')
  Call<KubernetesStack> createKubernetesStack(@Path('projectId') String projectId, @Body KubernetesStack kubernetesStack)

  @GET('v2-beta/projects/{projectId}/kubernetesStack/{id}')
  Call<KubernetesStack> findKubernetesStackById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/kubernetesStack/{id}')
  Call<KubernetesStack> updateKubernetesStack(@Path('projectId') String projectId, @Path('id') String id, @Body KubernetesStack kubernetesStack)

  @DELETE('v2-beta/projects/{projectId}/kubernetesStack/{id}')
  Call<KubernetesStack> deleteKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=rollback')
  Call<Stack> rollbackKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=upgrade')
  Call<KubernetesStack> upgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id, @Body KubernetesStackUpgrade kubernetesStackUpgrade)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=error')
  Call<Stack> errorKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=remove')
  Call<Stack> removeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStack/{id}?action=finishupgrade')
  Call<Stack> finishupgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/kubernetesStackUpgrade')
  Call<KubernetesStackUpgrade> createKubernetesStackUpgrade(@Path('projectId') String projectId, @Body KubernetesStackUpgrade kubernetesStackUpgrade)

  @GET('v2-beta/projects/{projectId}/kubernetesStackUpgrade/{id}')
  Call<KubernetesStackUpgrade> findKubernetesStackUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/label')
  Call<TypeCollection<Label>> listlabels(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/label')
  Call<TypeCollection<Label>> querylabels(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/label/{id}')
  Call<Label> findLabelById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/label/{id}?action=remove')
  Call<Label> removeLabel(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/launchConfig')
  Call<LaunchConfig> createLaunchConfig(@Path('projectId') String projectId, @Body LaunchConfig launchConfig)

  @GET('v2-beta/projects/{projectId}/launchConfig/{id}')
  Call<LaunchConfig> findLaunchConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/launchConfig/{id}')
  Call<LaunchConfig> updateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body LaunchConfig launchConfig)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=console')
  Call<InstanceConsole> consoleLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=restart')
  Call<Instance> restartLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=deallocate')
  Call<Instance> deallocateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=start')
  Call<Instance> startLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=purge')
  Call<Instance> purgeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=error')
  Call<Instance> errorLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=remove')
  Call<Instance> removeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=stop')
  Call<Instance> stopLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=allocate')
  Call<Instance> allocateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=updatehealthy')
  Call<Instance> updatehealthyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=migrate')
  Call<Instance> migrateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=execute')
  Call<HostAccess> executeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/launchConfig/{id}?action=proxy')
  Call<HostAccess> proxyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @POST('v2-beta/projects/{projectId}/lbConfig')
  Call<LbConfig> createLbConfig(@Path('projectId') String projectId, @Body LbConfig lbConfig)

  @GET('v2-beta/projects/{projectId}/lbConfig/{id}')
  Call<LbConfig> findLbConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/lbTargetConfig/{id}')
  Call<LbTargetConfig> findLbTargetConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicy')
  Call<LoadBalancerCookieStickinessPolicy> createLoadBalancerCookieStickinessPolicy(@Path('projectId') String projectId, @Body LoadBalancerCookieStickinessPolicy loadBalancerCookieStickinessPolicy)

  @GET('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicy/{id}')
  Call<LoadBalancerCookieStickinessPolicy> findLoadBalancerCookieStickinessPolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicy/{id}')
  Call<LoadBalancerCookieStickinessPolicy> updateLoadBalancerCookieStickinessPolicy(@Path('projectId') String projectId, @Path('id') String id, @Body LoadBalancerCookieStickinessPolicy loadBalancerCookieStickinessPolicy)

  @GET('v2-beta/projects/{projectId}/loadBalancerService')
  Call<TypeCollection<LoadBalancerService>> listloadBalancerServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/loadBalancerService')
  Call<TypeCollection<LoadBalancerService>> queryloadBalancerServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/loadBalancerService')
  Call<LoadBalancerService> createLoadBalancerService(@Path('projectId') String projectId, @Body LoadBalancerService loadBalancerService)

  @GET('v2-beta/projects/{projectId}/loadBalancerService/{id}')
  Call<LoadBalancerService> findLoadBalancerServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/loadBalancerService/{id}')
  Call<LoadBalancerService> updateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body LoadBalancerService loadBalancerService)

  @DELETE('v2-beta/projects/{projectId}/loadBalancerService/{id}')
  Call<LoadBalancerService> deleteLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=rollback')
  Call<Service> rollbackLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=upgrade')
  Call<Service> upgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=restart')
  Call<Service> restartLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=remove')
  Call<Service> removeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=deactivate')
  Call<Service> deactivateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=finishupgrade')
  Call<Service> finishupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=removeservicelink')
  Call<Service> removeservicelinkLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=continueupgrade')
  Call<Service> continueupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=activate')
  Call<Service> activateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=addservicelink')
  Call<Service> addservicelinkLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerService/{id}?action=setservicelinks')
  Call<Service> setservicelinksLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/logConfig')
  Call<LogConfig> createLogConfig(@Path('projectId') String projectId, @Body LogConfig logConfig)

  @GET('v2-beta/projects/{projectId}/logConfig/{id}')
  Call<LogConfig> findLogConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/machine')
  Call<TypeCollection<Machine>> listmachines(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/machine')
  Call<TypeCollection<Machine>> querymachines(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/machine')
  Call<Machine> createMachine(@Path('projectId') String projectId, @Body Machine machine)

  @GET('v2-beta/projects/{projectId}/machine/{id}')
  Call<Machine> findMachineById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/machine/{id}')
  Call<Machine> updateMachine(@Path('projectId') String projectId, @Path('id') String id, @Body Machine machine)

  @DELETE('v2-beta/projects/{projectId}/machine/{id}')
  Call<Machine> deleteMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machine/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrapMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machine/{id}?action=error')
  Call<PhysicalHost> errorMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machine/{id}?action=remove')
  Call<PhysicalHost> removeMachine(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/machineDriver')
  Call<TypeCollection<MachineDriver>> listmachineDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/machineDriver')
  Call<TypeCollection<MachineDriver>> querymachineDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/machineDriver/{id}')
  Call<MachineDriver> findMachineDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/mount')
  Call<TypeCollection<Mount>> listmounts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/mount')
  Call<TypeCollection<Mount>> querymounts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/mount/{id}')
  Call<Mount> findMountById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/mount/{id}?action=remove')
  Call<Mount> removeMount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/mount/{id}?action=deactivate')
  Call<Mount> deactivateMount(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/mountEntry/{id}')
  Call<MountEntry> findMountEntryById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/network')
  Call<TypeCollection<Network>> listnetworks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/network')
  Call<TypeCollection<Network>> querynetworks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/network')
  Call<Network> createNetwork(@Path('projectId') String projectId, @Body Network network)

  @GET('v2-beta/projects/{projectId}/network/{id}')
  Call<Network> findNetworkById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/network/{id}')
  Call<Network> updateNetwork(@Path('projectId') String projectId, @Path('id') String id, @Body Network network)

  @DELETE('v2-beta/projects/{projectId}/network/{id}')
  Call<Network> deleteNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/network/{id}?action=activate')
  Call<Network> activateNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/network/{id}?action=purge')
  Call<Network> purgeNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/network/{id}?action=remove')
  Call<Network> removeNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/network/{id}?action=deactivate')
  Call<Network> deactivateNetwork(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/networkDriver')
  Call<TypeCollection<NetworkDriver>> listnetworkDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkDriver')
  Call<TypeCollection<NetworkDriver>> querynetworkDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/networkDriver/{id}')
  Call<NetworkDriver> findNetworkDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriver/{id}?action=activate')
  Call<NetworkDriver> activateNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriver/{id}?action=remove')
  Call<NetworkDriver> removeNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriver/{id}?action=deactivate')
  Call<NetworkDriver> deactivateNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/networkDriverService')
  Call<TypeCollection<NetworkDriverService>> listnetworkDriverServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkDriverService')
  Call<TypeCollection<NetworkDriverService>> querynetworkDriverServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/networkDriverService')
  Call<NetworkDriverService> createNetworkDriverService(@Path('projectId') String projectId, @Body NetworkDriverService networkDriverService)

  @GET('v2-beta/projects/{projectId}/networkDriverService/{id}')
  Call<NetworkDriverService> findNetworkDriverServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/networkDriverService/{id}')
  Call<NetworkDriverService> updateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body NetworkDriverService networkDriverService)

  @DELETE('v2-beta/projects/{projectId}/networkDriverService/{id}')
  Call<NetworkDriverService> deleteNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=rollback')
  Call<Service> rollbackNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=upgrade')
  Call<Service> upgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=restart')
  Call<Service> restartNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=remove')
  Call<Service> removeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=deactivate')
  Call<Service> deactivateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=finishupgrade')
  Call<Service> finishupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=removeservicelink')
  Call<Service> removeservicelinkNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=continueupgrade')
  Call<Service> continueupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=activate')
  Call<Service> activateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=addservicelink')
  Call<Service> addservicelinkNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverService/{id}?action=setservicelinks')
  Call<Service> setservicelinksNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/networkPolicyRule')
  Call<NetworkPolicyRule> createNetworkPolicyRule(@Path('projectId') String projectId, @Body NetworkPolicyRule networkPolicyRule)

  @GET('v2-beta/projects/{projectId}/networkPolicyRule/{id}')
  Call<NetworkPolicyRule> findNetworkPolicyRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleBetween')
  Call<NetworkPolicyRuleBetween> createNetworkPolicyRuleBetween(@Path('projectId') String projectId, @Body NetworkPolicyRuleBetween networkPolicyRuleBetween)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleBetween/{id}')
  Call<NetworkPolicyRuleBetween> findNetworkPolicyRuleBetweenById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleMember')
  Call<NetworkPolicyRuleMember> createNetworkPolicyRuleMember(@Path('projectId') String projectId, @Body NetworkPolicyRuleMember networkPolicyRuleMember)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleMember/{id}')
  Call<NetworkPolicyRuleMember> findNetworkPolicyRuleMemberById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithin')
  Call<TypeCollection<NetworkPolicyRuleWithin>> listnetworkPolicyRuleWithins(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithin')
  Call<TypeCollection<NetworkPolicyRuleWithin>> querynetworkPolicyRuleWithins(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleWithin')
  Call<NetworkPolicyRuleWithin> createNetworkPolicyRuleWithin(@Path('projectId') String projectId, @Body NetworkPolicyRuleWithin networkPolicyRuleWithin)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithin/{id}')
  Call<NetworkPolicyRuleWithin> findNetworkPolicyRuleWithinById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/nfsConfig/{id}')
  Call<NfsConfig> findNfsConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/packetConfig')
  Call<PacketConfig> createPacketConfig(@Path('projectId') String projectId, @Body PacketConfig packetConfig)

  @GET('v2-beta/projects/{projectId}/packetConfig/{id}')
  Call<PacketConfig> findPacketConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/password')
  Call<TypeCollection<Password>> listpasswords(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/password')
  Call<TypeCollection<Password>> querypasswords(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/password')
  Call<Password> createPassword(@Path('projectId') String projectId, @Body Password password)

  @GET('v2-beta/projects/{projectId}/password/{id}')
  Call<Password> findPasswordById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/password/{id}')
  Call<Password> updatePassword(@Path('projectId') String projectId, @Path('id') String id, @Body Password password)

  @DELETE('v2-beta/projects/{projectId}/password/{id}')
  Call<Password> deletePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/password/{id}?action=activate')
  Call<Credential> activatePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/password/{id}?action=purge')
  Call<Credential> purgePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/password/{id}?action=remove')
  Call<Credential> removePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/password/{id}?action=deactivate')
  Call<Credential> deactivatePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/password/{id}?action=changesecret')
  Call<ChangeSecretInput> changesecretPassword(@Path('projectId') String projectId, @Path('id') String id, @Body ChangeSecretInput changeSecretInput)

  @GET('v2-beta/projects/{projectId}/physicalHost')
  Call<TypeCollection<PhysicalHost>> listphysicalHosts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/physicalHost')
  Call<TypeCollection<PhysicalHost>> queryphysicalHosts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/physicalHost/{id}')
  Call<PhysicalHost> findPhysicalHostById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHost/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrapPhysicalHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHost/{id}?action=error')
  Call<PhysicalHost> errorPhysicalHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHost/{id}?action=remove')
  Call<PhysicalHost> removePhysicalHost(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/port')
  Call<TypeCollection<Port>> listports(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/port')
  Call<TypeCollection<Port>> queryports(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/port/{id}')
  Call<Port> findPortById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/port/{id}')
  Call<Port> updatePort(@Path('projectId') String projectId, @Path('id') String id, @Body Port port)

  @POST('v2-beta/projects/{projectId}/port/{id}?action=activate')
  Call<Port> activatePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/port/{id}?action=purge')
  Call<Port> purgePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/port/{id}?action=remove')
  Call<Port> removePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/port/{id}?action=deactivate')
  Call<Port> deactivatePort(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/portRule')
  Call<PortRule> createPortRule(@Path('projectId') String projectId, @Body PortRule portRule)

  @GET('v2-beta/projects/{projectId}/portRule/{id}')
  Call<PortRule> findPortRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/project')
  Call<TypeCollection<Project>> listprojects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/project')
  Call<TypeCollection<Project>> queryprojects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/project/{id}')
  Call<Project> findProjectById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=upgrade')
  Call<Account> upgradeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=activate')
  Call<Account> activateProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=purge')
  Call<Account> purgeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=remove')
  Call<Account> removeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=deactivate')
  Call<Account> deactivateProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/project/{id}?action=setmembers')
  Call<SetProjectMembersInput> setmembersProject(@Path('projectId') String projectId, @Path('id') String id, @Body SetProjectMembersInput setProjectMembersInput)

  @GET('v2-beta/projects/{projectId}/projectMember')
  Call<TypeCollection<ProjectMember>> listprojectMembers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/projectMember')
  Call<TypeCollection<ProjectMember>> queryprojectMembers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/projectMember/{id}')
  Call<ProjectMember> findProjectMemberById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMember/{id}?action=activate')
  Call<ProjectMember> activateProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMember/{id}?action=purge')
  Call<ProjectMember> purgeProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMember/{id}?action=remove')
  Call<ProjectMember> removeProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMember/{id}?action=deactivate')
  Call<ProjectMember> deactivateProjectMember(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/projectTemplate')
  Call<TypeCollection<ProjectTemplate>> listprojectTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/projectTemplate')
  Call<TypeCollection<ProjectTemplate>> queryprojectTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/projectTemplate/{id}')
  Call<ProjectTemplate> findProjectTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectTemplate/{id}?action=remove')
  Call<ProjectTemplate> removeProjectTemplate(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/publicEndpoint/{id}')
  Call<PublicEndpoint> findPublicEndpointById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/pullTask')
  Call<TypeCollection<PullTask>> listpullTasks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/pullTask')
  Call<TypeCollection<PullTask>> querypullTasks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/pullTask')
  Call<PullTask> createPullTask(@Path('projectId') String projectId, @Body PullTask pullTask)

  @GET('v2-beta/projects/{projectId}/pullTask/{id}')
  Call<PullTask> findPullTaskById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/pullTask/{id}?action=remove')
  Call<GenericObject> removePullTask(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/recreateOnQuorumStrategyConfig')
  Call<RecreateOnQuorumStrategyConfig> createRecreateOnQuorumStrategyConfig(@Path('projectId') String projectId, @Body RecreateOnQuorumStrategyConfig recreateOnQuorumStrategyConfig)

  @GET('v2-beta/projects/{projectId}/recreateOnQuorumStrategyConfig/{id}')
  Call<RecreateOnQuorumStrategyConfig> findRecreateOnQuorumStrategyConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/region')
  Call<TypeCollection<Region>> listregions(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/region')
  Call<TypeCollection<Region>> queryregions(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/region/{id}')
  Call<Region> findRegionById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/region/{id}?action=activate')
  Call<Region> activateRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/region/{id}?action=purge')
  Call<Region> purgeRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/region/{id}?action=remove')
  Call<Region> removeRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/region/{id}?action=deactivate')
  Call<Region> deactivateRegion(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/register')
  Call<TypeCollection<Register>> listregister(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/register')
  Call<TypeCollection<Register>> queryregister(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/register')
  Call<Register> createRegister(@Path('projectId') String projectId, @Body Register register)

  @GET('v2-beta/projects/{projectId}/register/{id}')
  Call<Register> findRegisterById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/register/{id}?action=remove')
  Call<GenericObject> removeRegister(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/register/{id}?action=stop')
  Call<Instance> stopRegister(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @GET('v2-beta/projects/{projectId}/registrationToken')
  Call<TypeCollection<RegistrationToken>> listregistrationTokens(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registrationToken')
  Call<TypeCollection<RegistrationToken>> queryregistrationTokens(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registrationToken')
  Call<RegistrationToken> createRegistrationToken(@Path('projectId') String projectId, @Body RegistrationToken registrationToken)

  @GET('v2-beta/projects/{projectId}/registrationToken/{id}')
  Call<RegistrationToken> findRegistrationTokenById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationToken/{id}?action=activate')
  Call<Credential> activateRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationToken/{id}?action=purge')
  Call<Credential> purgeRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationToken/{id}?action=remove')
  Call<Credential> removeRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationToken/{id}?action=deactivate')
  Call<Credential> deactivateRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/registry')
  Call<TypeCollection<Registry>> listregistries(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registry')
  Call<TypeCollection<Registry>> queryregistries(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registry')
  Call<Registry> createRegistry(@Path('projectId') String projectId, @Body Registry registry)

  @GET('v2-beta/projects/{projectId}/registry/{id}')
  Call<Registry> findRegistryById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/registry/{id}')
  Call<Registry> updateRegistry(@Path('projectId') String projectId, @Path('id') String id, @Body Registry registry)

  @DELETE('v2-beta/projects/{projectId}/registry/{id}')
  Call<Registry> deleteRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registry/{id}?action=activate')
  Call<StoragePool> activateRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registry/{id}?action=purge')
  Call<StoragePool> purgeRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registry/{id}?action=remove')
  Call<StoragePool> removeRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registry/{id}?action=deactivate')
  Call<StoragePool> deactivateRegistry(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/registryCredential')
  Call<TypeCollection<RegistryCredential>> listregistryCredentials(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registryCredential')
  Call<TypeCollection<RegistryCredential>> queryregistryCredentials(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registryCredential')
  Call<RegistryCredential> createRegistryCredential(@Path('projectId') String projectId, @Body RegistryCredential registryCredential)

  @GET('v2-beta/projects/{projectId}/registryCredential/{id}')
  Call<RegistryCredential> findRegistryCredentialById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/registryCredential/{id}')
  Call<RegistryCredential> updateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id, @Body RegistryCredential registryCredential)

  @DELETE('v2-beta/projects/{projectId}/registryCredential/{id}')
  Call<RegistryCredential> deleteRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredential/{id}?action=activate')
  Call<Credential> activateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredential/{id}?action=purge')
  Call<Credential> purgeRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredential/{id}?action=remove')
  Call<Credential> removeRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredential/{id}?action=deactivate')
  Call<Credential> deactivateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/restartPolicy')
  Call<RestartPolicy> createRestartPolicy(@Path('projectId') String projectId, @Body RestartPolicy restartPolicy)

  @GET('v2-beta/projects/{projectId}/restartPolicy/{id}')
  Call<RestartPolicy> findRestartPolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/restoreFromBackupInput/{id}')
  Call<RestoreFromBackupInput> findRestoreFromBackupInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/revertToSnapshotInput/{id}')
  Call<RevertToSnapshotInput> findRevertToSnapshotInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/rollingRestartStrategy')
  Call<RollingRestartStrategy> createRollingRestartStrategy(@Path('projectId') String projectId, @Body RollingRestartStrategy rollingRestartStrategy)

  @GET('v2-beta/projects/{projectId}/rollingRestartStrategy/{id}')
  Call<RollingRestartStrategy> findRollingRestartStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/scalePolicy/{id}')
  Call<ScalePolicy> findScalePolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrade')
  Call<TypeCollection<ScheduledUpgrade>> listscheduledUpgrades(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrade')
  Call<TypeCollection<ScheduledUpgrade>> queryscheduledUpgrades(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrade/{id}')
  Call<ScheduledUpgrade> findScheduledUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/scheduledUpgrade/{id}?action=start')
  Call<ScheduledUpgrade> startScheduledUpgrade(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/scheduledUpgrade/{id}?action=remove')
  Call<ScheduledUpgrade> removeScheduledUpgrade(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig')
  Call<SecondaryLaunchConfig> createSecondaryLaunchConfig(@Path('projectId') String projectId, @Body SecondaryLaunchConfig secondaryLaunchConfig)

  @GET('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}')
  Call<SecondaryLaunchConfig> findSecondaryLaunchConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}')
  Call<SecondaryLaunchConfig> updateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body SecondaryLaunchConfig secondaryLaunchConfig)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=console')
  Call<InstanceConsole> consoleSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=restart')
  Call<Instance> restartSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=deallocate')
  Call<Instance> deallocateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=start')
  Call<Instance> startSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=purge')
  Call<Instance> purgeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=error')
  Call<Instance> errorSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=remove')
  Call<Instance> removeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=stop')
  Call<Instance> stopSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=allocate')
  Call<Instance> allocateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=updatehealthy')
  Call<Instance> updatehealthySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=migrate')
  Call<Instance> migrateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=execute')
  Call<HostAccess> executeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfig/{id}?action=proxy')
  Call<HostAccess> proxySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/secret')
  Call<TypeCollection<Secret>> listsecrets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/secret')
  Call<TypeCollection<Secret>> querysecrets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/secret')
  Call<Secret> createSecret(@Path('projectId') String projectId, @Body Secret secret)

  @GET('v2-beta/projects/{projectId}/secret/{id}')
  Call<Secret> findSecretById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/secret/{id}')
  Call<Secret> updateSecret(@Path('projectId') String projectId, @Path('id') String id, @Body Secret secret)

  @DELETE('v2-beta/projects/{projectId}/secret/{id}')
  Call<Secret> deleteSecret(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secret/{id}?action=remove')
  Call<Secret> removeSecret(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/secretReference')
  Call<SecretReference> createSecretReference(@Path('projectId') String projectId, @Body SecretReference secretReference)

  @GET('v2-beta/projects/{projectId}/secretReference/{id}')
  Call<SecretReference> findSecretReferenceById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/service')
  Call<TypeCollection<Service>> listservices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/service')
  Call<TypeCollection<Service>> queryservices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/service')
  Call<Service> createService(@Path('projectId') String projectId, @Body Service service)

  @GET('v2-beta/projects/{projectId}/service/{id}')
  Call<Service> findServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/service/{id}')
  Call<Service> updateService(@Path('projectId') String projectId, @Path('id') String id, @Body Service service)

  @DELETE('v2-beta/projects/{projectId}/service/{id}')
  Call<Service> deleteService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=rollback')
  Call<Service> rollbackService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=upgrade')
  Call<Service> upgradeService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=restart')
  Call<Service> restartService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=remove')
  Call<Service> removeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=deactivate')
  Call<Service> deactivateService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=finishupgrade')
  Call<Service> finishupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=removeservicelink')
  Call<Service> removeservicelinkService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=continueupgrade')
  Call<Service> continueupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=activate')
  Call<Service> activateService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=addservicelink')
  Call<Service> addservicelinkService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/service/{id}?action=setservicelinks')
  Call<Service> setservicelinksService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/serviceBinding')
  Call<ServiceBinding> createServiceBinding(@Path('projectId') String projectId, @Body ServiceBinding serviceBinding)

  @GET('v2-beta/projects/{projectId}/serviceBinding/{id}')
  Call<ServiceBinding> findServiceBindingById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/serviceBinding/{id}')
  Call<ServiceBinding> updateServiceBinding(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceBinding serviceBinding)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMap')
  Call<TypeCollection<ServiceConsumeMap>> listserviceConsumeMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMap')
  Call<TypeCollection<ServiceConsumeMap>> queryserviceConsumeMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMap/{id}')
  Call<ServiceConsumeMap> findServiceConsumeMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceConsumeMap/{id}?action=remove')
  Call<ServiceConsumeMap> removeServiceConsumeMap(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/serviceEvent')
  Call<TypeCollection<ServiceEvent>> listserviceEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceEvent')
  Call<TypeCollection<ServiceEvent>> queryserviceEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceEvent/{id}')
  Call<ServiceEvent> findServiceEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceEvent/{id}?action=remove')
  Call<ServiceEvent> removeServiceEvent(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/serviceExposeMap')
  Call<TypeCollection<ServiceExposeMap>> listserviceExposeMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceExposeMap')
  Call<TypeCollection<ServiceExposeMap>> queryserviceExposeMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceExposeMap/{id}')
  Call<ServiceExposeMap> findServiceExposeMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceExposeMap/{id}?action=remove')
  Call<ServiceExposeMap> removeServiceExposeMap(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/serviceLink')
  Call<ServiceLink> createServiceLink(@Path('projectId') String projectId, @Body ServiceLink serviceLink)

  @GET('v2-beta/projects/{projectId}/serviceLink/{id}')
  Call<ServiceLink> findServiceLinkById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceLog')
  Call<TypeCollection<ServiceLog>> listserviceLogs(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceLog')
  Call<TypeCollection<ServiceLog>> queryserviceLogs(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceLog/{id}')
  Call<ServiceLog> findServiceLogById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceProxy')
  Call<TypeCollection<ServiceProxy>> listserviceProxies(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceProxy')
  Call<TypeCollection<ServiceProxy>> queryserviceProxies(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/serviceProxy')
  Call<ServiceProxy> createServiceProxy(@Path('projectId') String projectId, @Body ServiceProxy serviceProxy)

  @GET('v2-beta/projects/{projectId}/serviceProxy/{id}')
  Call<ServiceProxy> findServiceProxyById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceRestart')
  Call<ServiceRestart> createServiceRestart(@Path('projectId') String projectId, @Body ServiceRestart serviceRestart)

  @GET('v2-beta/projects/{projectId}/serviceRestart/{id}')
  Call<ServiceRestart> findServiceRestartById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceUpgrade')
  Call<ServiceUpgrade> createServiceUpgrade(@Path('projectId') String projectId, @Body ServiceUpgrade serviceUpgrade)

  @GET('v2-beta/projects/{projectId}/serviceUpgrade/{id}')
  Call<ServiceUpgrade> findServiceUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceUpgradeStrategy/{id}')
  Call<ServiceUpgradeStrategy> findServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/servicesPortRange')
  Call<ServicesPortRange> createServicesPortRange(@Path('projectId') String projectId, @Body ServicesPortRange servicesPortRange)

  @GET('v2-beta/projects/{projectId}/servicesPortRange/{id}')
  Call<ServicesPortRange> findServicesPortRangeById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/servicesPortRange/{id}')
  Call<ServicesPortRange> updateServicesPortRange(@Path('projectId') String projectId, @Path('id') String id, @Body ServicesPortRange servicesPortRange)

  @POST('v2-beta/projects/{projectId}/setProjectMembersInput')
  Call<SetProjectMembersInput> createSetProjectMembersInput(@Path('projectId') String projectId, @Body SetProjectMembersInput setProjectMembersInput)

  @GET('v2-beta/projects/{projectId}/setProjectMembersInput/{id}')
  Call<SetProjectMembersInput> findSetProjectMembersInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/setServiceLinksInput')
  Call<SetServiceLinksInput> createSetServiceLinksInput(@Path('projectId') String projectId, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/setServiceLinksInput/{id}')
  Call<SetServiceLinksInput> findSetServiceLinksInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/setting')
  Call<TypeCollection<Setting>> listsettings(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/setting')
  Call<TypeCollection<Setting>> querysettings(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/setting/{id}')
  Call<Setting> findSettingById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/snapshot')
  Call<TypeCollection<Snapshot>> listsnapshots(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/snapshot')
  Call<TypeCollection<Snapshot>> querysnapshots(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/snapshot/{id}')
  Call<Snapshot> findSnapshotById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/snapshot/{id}')
  Call<Snapshot> deleteSnapshot(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/snapshot/{id}?action=backup')
  Call<Backup> backupSnapshot(@Path('projectId') String projectId, @Path('id') String id, @Body SnapshotBackupInput snapshotBackupInput)

  @POST('v2-beta/projects/{projectId}/snapshot/{id}?action=remove')
  Call<Snapshot> removeSnapshot(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/snapshotBackupInput/{id}')
  Call<SnapshotBackupInput> findSnapshotBackupInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/stack')
  Call<TypeCollection<Stack>> liststacks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/stack')
  Call<TypeCollection<Stack>> querystacks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/stack')
  Call<Stack> createStack(@Path('projectId') String projectId, @Body Stack stack)

  @GET('v2-beta/projects/{projectId}/stack/{id}')
  Call<Stack> findStackById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/stack/{id}')
  Call<Stack> updateStack(@Path('projectId') String projectId, @Path('id') String id, @Body Stack stack)

  @DELETE('v2-beta/projects/{projectId}/stack/{id}')
  Call<Stack> deleteStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=rollback')
  Call<Stack> rollbackStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=deactivateservices')
  Call<Stack> deactivateservicesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=activateservices')
  Call<Stack> activateservicesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=upgrade')
  Call<Stack> upgradeStack(@Path('projectId') String projectId, @Path('id') String id, @Body StackUpgrade stackUpgrade)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=addoutputs')
  Call<Stack> addoutputsStack(@Path('projectId') String projectId, @Path('id') String id, @Body AddOutputsInput addOutputsInput)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=exportconfig')
  Call<ComposeConfig> exportconfigStack(@Path('projectId') String projectId, @Path('id') String id, @Body ComposeConfigInput composeConfigInput)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=error')
  Call<Stack> errorStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=remove')
  Call<Stack> removeStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stack/{id}?action=finishupgrade')
  Call<Stack> finishupgradeStack(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/stackUpgrade')
  Call<StackUpgrade> createStackUpgrade(@Path('projectId') String projectId, @Body StackUpgrade stackUpgrade)

  @GET('v2-beta/projects/{projectId}/stackUpgrade/{id}')
  Call<StackUpgrade> findStackUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/statsAccess/{id}')
  Call<StatsAccess> findStatsAccessById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/storageDriver')
  Call<TypeCollection<StorageDriver>> liststorageDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storageDriver')
  Call<TypeCollection<StorageDriver>> querystorageDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/storageDriver/{id}')
  Call<StorageDriver> findStorageDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriver/{id}?action=activate')
  Call<StorageDriver> activateStorageDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriver/{id}?action=remove')
  Call<StorageDriver> removeStorageDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriver/{id}?action=deactivate')
  Call<StorageDriver> deactivateStorageDriver(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/storageDriverService')
  Call<TypeCollection<StorageDriverService>> liststorageDriverServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storageDriverService')
  Call<TypeCollection<StorageDriverService>> querystorageDriverServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/storageDriverService')
  Call<StorageDriverService> createStorageDriverService(@Path('projectId') String projectId, @Body StorageDriverService storageDriverService)

  @GET('v2-beta/projects/{projectId}/storageDriverService/{id}')
  Call<StorageDriverService> findStorageDriverServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/storageDriverService/{id}')
  Call<StorageDriverService> updateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body StorageDriverService storageDriverService)

  @DELETE('v2-beta/projects/{projectId}/storageDriverService/{id}')
  Call<StorageDriverService> deleteStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=rollback')
  Call<Service> rollbackStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=upgrade')
  Call<Service> upgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=restart')
  Call<Service> restartStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=remove')
  Call<Service> removeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=deactivate')
  Call<Service> deactivateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=finishupgrade')
  Call<Service> finishupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=removeservicelink')
  Call<Service> removeservicelinkStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=continueupgrade')
  Call<Service> continueupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=activate')
  Call<Service> activateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=addservicelink')
  Call<Service> addservicelinkStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverService/{id}?action=setservicelinks')
  Call<Service> setservicelinksStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/storagePool')
  Call<TypeCollection<StoragePool>> liststoragePools(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storagePool')
  Call<TypeCollection<StoragePool>> querystoragePools(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/storagePool/{id}')
  Call<StoragePool> findStoragePoolById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePool/{id}?action=activate')
  Call<StoragePool> activateStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePool/{id}?action=purge')
  Call<StoragePool> purgeStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePool/{id}?action=remove')
  Call<StoragePool> removeStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePool/{id}?action=deactivate')
  Call<StoragePool> deactivateStoragePool(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/subnet')
  Call<TypeCollection<Subnet>> listsubnets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/subnet')
  Call<TypeCollection<Subnet>> querysubnets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/subnet/{id}')
  Call<Subnet> findSubnetById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnet/{id}?action=activate')
  Call<Subnet> activateSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnet/{id}?action=purge')
  Call<Subnet> purgeSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnet/{id}?action=remove')
  Call<Subnet> removeSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnet/{id}?action=deactivate')
  Call<Subnet> deactivateSubnet(@Path('projectId') String projectId, @Path('id') String id)


  @POST('v2-beta/projects/{projectId}/targetPortRule')
  Call<TargetPortRule> createTargetPortRule(@Path('projectId') String projectId, @Body TargetPortRule targetPortRule)

  @GET('v2-beta/projects/{projectId}/targetPortRule/{id}')
  Call<TargetPortRule> findTargetPortRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/toServiceUpgradeStrategy')
  Call<ToServiceUpgradeStrategy> createToServiceUpgradeStrategy(@Path('projectId') String projectId, @Body ToServiceUpgradeStrategy toServiceUpgradeStrategy)

  @GET('v2-beta/projects/{projectId}/toServiceUpgradeStrategy/{id}')
  Call<ToServiceUpgradeStrategy> findToServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/typeDocumentation')
  Call<TypeCollection<TypeDocumentation>> listtypeDocumentations(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/typeDocumentation')
  Call<TypeCollection<TypeDocumentation>> querytypeDocumentations(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/typeDocumentation/{id}')
  Call<TypeDocumentation> findTypeDocumentationById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ulimit')
  Call<Ulimit> createUlimit(@Path('projectId') String projectId, @Body Ulimit ulimit)

  @GET('v2-beta/projects/{projectId}/ulimit/{id}')
  Call<Ulimit> findUlimitById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/virtualMachine')
  Call<TypeCollection<VirtualMachine>> listvirtualMachines(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/virtualMachine')
  Call<TypeCollection<VirtualMachine>> queryvirtualMachines(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/virtualMachine')
  Call<VirtualMachine> createVirtualMachine(@Path('projectId') String projectId, @Body VirtualMachine virtualMachine)

  @GET('v2-beta/projects/{projectId}/virtualMachine/{id}')
  Call<VirtualMachine> findVirtualMachineById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/virtualMachine/{id}')
  Call<VirtualMachine> updateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body VirtualMachine virtualMachine)

  @DELETE('v2-beta/projects/{projectId}/virtualMachine/{id}')
  Call<VirtualMachine> deleteVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=console')
  Call<InstanceConsole> consoleVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=restart')
  Call<Instance> restartVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=deallocate')
  Call<Instance> deallocateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=start')
  Call<Instance> startVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=purge')
  Call<Instance> purgeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=error')
  Call<Instance> errorVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=remove')
  Call<Instance> removeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=stop')
  Call<Instance> stopVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=allocate')
  Call<Instance> allocateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=updatehealthy')
  Call<Instance> updatehealthyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=migrate')
  Call<Instance> migrateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=logs')
  Call<HostAccess> logsVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerLogs containerLogs)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=execute')
  Call<HostAccess> executeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/virtualMachine/{id}?action=proxy')
  Call<HostAccess> proxyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @POST('v2-beta/projects/{projectId}/virtualMachineDisk')
  Call<VirtualMachineDisk> createVirtualMachineDisk(@Path('projectId') String projectId, @Body VirtualMachineDisk virtualMachineDisk)

  @GET('v2-beta/projects/{projectId}/virtualMachineDisk/{id}')
  Call<VirtualMachineDisk> findVirtualMachineDiskById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volume')
  Call<TypeCollection<Volume>> listvolumes(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/volume')
  Call<TypeCollection<Volume>> queryvolumes(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/volume')
  Call<Volume> createVolume(@Path('projectId') String projectId, @Body Volume volume)

  @GET('v2-beta/projects/{projectId}/volume/{id}')
  Call<Volume> findVolumeById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/volume/{id}')
  Call<Volume> updateVolume(@Path('projectId') String projectId, @Path('id') String id, @Body Volume volume)

  @DELETE('v2-beta/projects/{projectId}/volume/{id}')
  Call<Volume> deleteVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=allocate')
  Call<Volume> allocateVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=restorefrombackup')
  Call<Volume> restorefrombackupVolume(@Path('projectId') String projectId, @Path('id') String id, @Body RestoreFromBackupInput restoreFromBackupInput)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=deallocate')
  Call<Volume> deallocateVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=purge')
  Call<Volume> purgeVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=remove')
  Call<Volume> removeVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=reverttosnapshot')
  Call<Volume> reverttosnapshotVolume(@Path('projectId') String projectId, @Path('id') String id, @Body RevertToSnapshotInput revertToSnapshotInput)

  @POST('v2-beta/projects/{projectId}/volume/{id}?action=snapshot')
  Call<Snapshot> snapshotVolume(@Path('projectId') String projectId, @Path('id') String id, @Body VolumeSnapshotInput volumeSnapshotInput)

  @POST('v2-beta/projects/{projectId}/volumeActivateInput')
  Call<VolumeActivateInput> createVolumeActivateInput(@Path('projectId') String projectId, @Body VolumeActivateInput volumeActivateInput)

  @GET('v2-beta/projects/{projectId}/volumeActivateInput/{id}')
  Call<VolumeActivateInput> findVolumeActivateInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volumeSnapshotInput/{id}')
  Call<VolumeSnapshotInput> findVolumeSnapshotInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volumeTemplate')
  Call<TypeCollection<VolumeTemplate>> listvolumeTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/volumeTemplate')
  Call<TypeCollection<VolumeTemplate>> queryvolumeTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/volumeTemplate')
  Call<VolumeTemplate> createVolumeTemplate(@Path('projectId') String projectId, @Body VolumeTemplate volumeTemplate)

  @GET('v2-beta/projects/{projectId}/volumeTemplate/{id}')
  Call<VolumeTemplate> findVolumeTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplate/{id}?action=activate')
  Call<VolumeTemplate> activateVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplate/{id}?action=purge')
  Call<VolumeTemplate> purgeVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplate/{id}?action=remove')
  Call<VolumeTemplate> removeVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplate/{id}?action=deactivate')
  Call<VolumeTemplate> deactivateVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

}
