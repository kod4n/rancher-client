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

  @GET('v2-beta/projects/{projectId}/accounts')
  Call<TypeCollection<Account>> listAccounts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/accounts')
  Call<TypeCollection<Account>> queryAccounts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/accounts/{id}')
  Call<Account> findAccountById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/accounts/{id}?action=upgrade')
  Call<Account> upgradeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/accounts/{id}?action=activate')
  Call<Account> activateAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/accounts/{id}?action=purge')
  Call<Account> purgeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/accounts/{id}?action=remove')
  Call<Account> removeAccount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/accounts/{id}?action=deactivate')
  Call<Account> deactivateAccount(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/activeSettings/{id}')
  Call<ActiveSetting> findActiveSettingById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/addOutputsInputs/{id}')
  Call<AddOutputsInput> findAddOutputsInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/addRemoveServiceLinkInputs')
  Call<AddRemoveServiceLinkInput> createAddRemoveServiceLinkInput(@Path('projectId') String projectId, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @GET('v2-beta/projects/{projectId}/addRemoveServiceLinkInputs/{id}')
  Call<AddRemoveServiceLinkInput> findAddRemoveServiceLinkInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/amazonec2Configs')
  Call<Amazonec2Config> createAmazonec2Config(@Path('projectId') String projectId, @Body Amazonec2Config amazonec2Config)

  @GET('v2-beta/projects/{projectId}/amazonec2Configs/{id}')
  Call<Amazonec2Config> findAmazonec2ConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/apiKeys')
  Call<TypeCollection<ApiKey>> listApiKeys(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/apiKeys')
  Call<TypeCollection<ApiKey>> queryApiKeys(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/apiKeys')
  Call<ApiKey> createApiKey(@Path('projectId') String projectId, @Body ApiKey apiKey)

  @GET('v2-beta/projects/{projectId}/apiKeys/{id}')
  Call<ApiKey> findApiKeyById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/apiKeys/{id}')
  Call<ApiKey> updateApiKey(@Path('projectId') String projectId, @Path('id') String id, @Body ApiKey apiKey)

  @DELETE('v2-beta/projects/{projectId}/apiKeys/{id}')
  Call<ApiKey> deleteApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKeys/{id}?action=activate')
  Call<Credential> activateApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKeys/{id}?action=purge')
  Call<Credential> purgeApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKeys/{id}?action=remove')
  Call<Credential> removeApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/apiKeys/{id}?action=deactivate')
  Call<Credential> deactivateApiKey(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/auditLogs')
  Call<TypeCollection<AuditLog>> listAuditLogs(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/auditLogs')
  Call<TypeCollection<AuditLog>> queryAuditLogs(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/auditLogs/{id}')
  Call<AuditLog> findAuditLogById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/azureConfigs')
  Call<AzureConfig> createAzureConfig(@Path('projectId') String projectId, @Body AzureConfig azureConfig)

  @GET('v2-beta/projects/{projectId}/azureConfigs/{id}')
  Call<AzureConfig> findAzureConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/backups')
  Call<TypeCollection<Backup>> listBackups(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/backups')
  Call<TypeCollection<Backup>> queryBackups(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/backups/{id}')
  Call<Backup> findBackupById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/backups/{id}')
  Call<Backup> deleteBackup(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/backups/{id}?action=remove')
  Call<Backup> removeBackup(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/backupTargets')
  Call<TypeCollection<BackupTarget>> listBackupTargets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/backupTargets')
  Call<TypeCollection<BackupTarget>> queryBackupTargets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/backupTargets')
  Call<BackupTarget> createBackupTarget(@Path('projectId') String projectId, @Body BackupTarget backupTarget)

  @GET('v2-beta/projects/{projectId}/backupTargets/{id}')
  Call<BackupTarget> findBackupTargetById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/backupTargets/{id}')
  Call<BackupTarget> deleteBackupTarget(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/backupTargets/{id}?action=remove')
  Call<BackupTarget> removeBackupTarget(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/baseMachineConfigs/{id}')
  Call<BaseMachineConfig> findBaseMachineConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/bindings')
  Call<Binding> createBinding(@Path('projectId') String projectId, @Body Binding binding)

  @GET('v2-beta/projects/{projectId}/bindings/{id}')
  Call<Binding> findBindingById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/bindings/{id}')
  Call<Binding> updateBinding(@Path('projectId') String projectId, @Path('id') String id, @Body Binding binding)

  @POST('v2-beta/projects/{projectId}/blkioDeviceOptions')
  Call<BlkioDeviceOption> createBlkioDeviceOption(@Path('projectId') String projectId, @Body BlkioDeviceOption blkioDeviceOption)

  @GET('v2-beta/projects/{projectId}/blkioDeviceOptions/{id}')
  Call<BlkioDeviceOption> findBlkioDeviceOptionById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/catalogTemplates/{id}')
  Call<CatalogTemplate> findCatalogTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/certificates')
  Call<TypeCollection<Certificate>> listCertificates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/certificates')
  Call<TypeCollection<Certificate>> queryCertificates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/certificates')
  Call<Certificate> createCertificate(@Path('projectId') String projectId, @Body Certificate certificate)

  @GET('v2-beta/projects/{projectId}/certificates/{id}')
  Call<Certificate> findCertificateById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/certificates/{id}')
  Call<Certificate> updateCertificate(@Path('projectId') String projectId, @Path('id') String id, @Body Certificate certificate)

  @DELETE('v2-beta/projects/{projectId}/certificates/{id}')
  Call<Certificate> deleteCertificate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/certificates/{id}?action=remove')
  Call<Certificate> removeCertificate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/changeSecretInputs')
  Call<ChangeSecretInput> createChangeSecretInput(@Path('projectId') String projectId, @Body ChangeSecretInput changeSecretInput)

  @GET('v2-beta/projects/{projectId}/changeSecretInputs/{id}')
  Call<ChangeSecretInput> findChangeSecretInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/composeConfigs/{id}')
  Call<ComposeConfig> findComposeConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeConfigInputs')
  Call<ComposeConfigInput> createComposeConfigInput(@Path('projectId') String projectId, @Body ComposeConfigInput composeConfigInput)

  @GET('v2-beta/projects/{projectId}/composeConfigInputs/{id}')
  Call<ComposeConfigInput> findComposeConfigInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/composeProjects')
  Call<TypeCollection<ComposeProject>> listComposeProjects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/composeProjects')
  Call<TypeCollection<ComposeProject>> queryComposeProjects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/composeProjects')
  Call<ComposeProject> createComposeProject(@Path('projectId') String projectId, @Body ComposeProject composeProject)

  @GET('v2-beta/projects/{projectId}/composeProjects/{id}')
  Call<ComposeProject> findComposeProjectById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/composeProjects/{id}')
  Call<ComposeProject> updateComposeProject(@Path('projectId') String projectId, @Path('id') String id, @Body ComposeProject composeProject)

  @DELETE('v2-beta/projects/{projectId}/composeProjects/{id}')
  Call<ComposeProject> deleteComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProjects/{id}?action=rollback')
  Call<Stack> rollbackComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProjects/{id}?action=error')
  Call<Stack> errorComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProjects/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProjects/{id}?action=remove')
  Call<Stack> removeComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeProjects/{id}?action=finishupgrade')
  Call<Stack> finishupgradeComposeProject(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/composeServices')
  Call<TypeCollection<ComposeService>> listComposeServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/composeServices')
  Call<TypeCollection<ComposeService>> queryComposeServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/composeServices/{id}')
  Call<ComposeService> findComposeServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/composeServices/{id}')
  Call<ComposeService> deleteComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=rollback')
  Call<Service> rollbackComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=remove')
  Call<Service> removeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=activate')
  Call<Service> activateComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/composeServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeComposeService(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/containers')
  Call<TypeCollection<Container>> listContainers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/containers')
  Call<TypeCollection<Container>> queryContainers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/containers')
  Call<Container> createContainer(@Path('projectId') String projectId, @Body Container container)

  @GET('v2-beta/projects/{projectId}/containers/{id}')
  Call<Container> findContainerById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/containers/{id}')
  Call<Container> updateContainer(@Path('projectId') String projectId, @Path('id') String id, @Body Container container)

  @DELETE('v2-beta/projects/{projectId}/containers/{id}')
  Call<Container> deleteContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=console')
  Call<InstanceConsole> consoleContainer(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=restart')
  Call<Instance> restartContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=deallocate')
  Call<Instance> deallocateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=start')
  Call<Instance> startContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=purge')
  Call<Instance> purgeContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=error')
  Call<Instance> errorContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=remove')
  Call<Instance> removeContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=stop')
  Call<Instance> stopContainer(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=allocate')
  Call<Instance> allocateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=updatehealthy')
  Call<Instance> updatehealthyContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=migrate')
  Call<Instance> migrateContainer(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=logs')
  Call<HostAccess> logsContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerLogs containerLogs)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=execute')
  Call<HostAccess> executeContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/containers/{id}?action=proxy')
  Call<HostAccess> proxyContainer(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/containerEvents')
  Call<TypeCollection<ContainerEvent>> listContainerEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/containerEvents')
  Call<TypeCollection<ContainerEvent>> queryContainerEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/containerEvents/{id}')
  Call<ContainerEvent> findContainerEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerEvents/{id}?action=remove')
  Call<ContainerEvent> removeContainerEvent(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerExecs')
  Call<ContainerExec> createContainerExec(@Path('projectId') String projectId, @Body ContainerExec containerExec)

  @GET('v2-beta/projects/{projectId}/containerExecs/{id}')
  Call<ContainerExec> findContainerExecById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerLogses')
  Call<ContainerLogs> createContainerLogs(@Path('projectId') String projectId, @Body ContainerLogs containerLogs)

  @GET('v2-beta/projects/{projectId}/containerLogses/{id}')
  Call<ContainerLogs> findContainerLogsById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/containerProxys')
  Call<ContainerProxy> createContainerProxy(@Path('projectId') String projectId, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/containerProxys/{id}')
  Call<ContainerProxy> findContainerProxyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/credentials')
  Call<TypeCollection<Credential>> listCredentials(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/credentials')
  Call<TypeCollection<Credential>> queryCredentials(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/credentials/{id}')
  Call<Credential> findCredentialById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credentials/{id}?action=activate')
  Call<Credential> activateCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credentials/{id}?action=purge')
  Call<Credential> purgeCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credentials/{id}?action=remove')
  Call<Credential> removeCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/credentials/{id}?action=deactivate')
  Call<Credential> deactivateCredential(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/defaultNetworks/{id}')
  Call<DefaultNetwork> findDefaultNetworkById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetworks/{id}?action=activate')
  Call<Network> activateDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetworks/{id}?action=purge')
  Call<Network> purgeDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetworks/{id}?action=remove')
  Call<Network> removeDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/defaultNetworks/{id}?action=deactivate')
  Call<Network> deactivateDefaultNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/digitaloceanConfigs')
  Call<DigitaloceanConfig> createDigitaloceanConfig(@Path('projectId') String projectId, @Body DigitaloceanConfig digitaloceanConfig)

  @GET('v2-beta/projects/{projectId}/digitaloceanConfigs/{id}')
  Call<DigitaloceanConfig> findDigitaloceanConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/dnsServices')
  Call<TypeCollection<DnsService>> listDnsServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/dnsServices')
  Call<TypeCollection<DnsService>> queryDnsServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/dnsServices')
  Call<DnsService> createDnsService(@Path('projectId') String projectId, @Body DnsService dnsService)

  @GET('v2-beta/projects/{projectId}/dnsServices/{id}')
  Call<DnsService> findDnsServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/dnsServices/{id}')
  Call<DnsService> updateDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body DnsService dnsService)

  @DELETE('v2-beta/projects/{projectId}/dnsServices/{id}')
  Call<DnsService> deleteDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=rollback')
  Call<Service> rollbackDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=upgrade')
  Call<Service> upgradeDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=restart')
  Call<Service> restartDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=remove')
  Call<Service> removeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=deactivate')
  Call<Service> deactivateDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=removeservicelink')
  Call<Service> removeservicelinkDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=activate')
  Call<Service> activateDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=addservicelink')
  Call<Service> addservicelinkDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeDnsService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/dnsServices/{id}?action=setservicelinks')
  Call<Service> setservicelinksDnsService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/dockerBuilds')
  Call<DockerBuild> createDockerBuild(@Path('projectId') String projectId, @Body DockerBuild dockerBuild)

  @GET('v2-beta/projects/{projectId}/dockerBuilds/{id}')
  Call<DockerBuild> findDockerBuildById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalDnsEvents')
  Call<TypeCollection<ExternalDnsEvent>> listExternalDnsEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalDnsEvents')
  Call<TypeCollection<ExternalDnsEvent>> queryExternalDnsEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalDnsEvents/{id}')
  Call<ExternalDnsEvent> findExternalDnsEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalDnsEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalDnsEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalEvents')
  Call<TypeCollection<ExternalEvent>> listExternalEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalEvents')
  Call<TypeCollection<ExternalEvent>> queryExternalEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalEvents/{id}')
  Call<ExternalEvent> findExternalEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalHostEvents')
  Call<TypeCollection<ExternalHostEvent>> listExternalHostEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalHostEvents')
  Call<TypeCollection<ExternalHostEvent>> queryExternalHostEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/externalHostEvents')
  Call<ExternalHostEvent> createExternalHostEvent(@Path('projectId') String projectId, @Body ExternalHostEvent externalHostEvent)

  @GET('v2-beta/projects/{projectId}/externalHostEvents/{id}')
  Call<ExternalHostEvent> findExternalHostEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalHostEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalHostEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalServices')
  Call<TypeCollection<ExternalService>> listExternalServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalServices')
  Call<TypeCollection<ExternalService>> queryExternalServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/externalServices')
  Call<ExternalService> createExternalService(@Path('projectId') String projectId, @Body ExternalService externalService)

  @GET('v2-beta/projects/{projectId}/externalServices/{id}')
  Call<ExternalService> findExternalServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/externalServices/{id}')
  Call<ExternalService> updateExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ExternalService externalService)

  @DELETE('v2-beta/projects/{projectId}/externalServices/{id}')
  Call<ExternalService> deleteExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=rollback')
  Call<Service> rollbackExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=upgrade')
  Call<Service> upgradeExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=restart')
  Call<Service> restartExternalService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=remove')
  Call<Service> removeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=deactivate')
  Call<Service> deactivateExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=activate')
  Call<Service> activateExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeExternalService(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalServiceEvents')
  Call<TypeCollection<ExternalServiceEvent>> listExternalServiceEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalServiceEvents')
  Call<TypeCollection<ExternalServiceEvent>> queryExternalServiceEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalServiceEvents/{id}')
  Call<ExternalServiceEvent> findExternalServiceEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalServiceEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalServiceEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvents')
  Call<TypeCollection<ExternalStoragePoolEvent>> listExternalStoragePoolEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvents')
  Call<TypeCollection<ExternalStoragePoolEvent>> queryExternalStoragePoolEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalStoragePoolEvents/{id}')
  Call<ExternalStoragePoolEvent> findExternalStoragePoolEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalStoragePoolEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalStoragePoolEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/externalVolumeEvents')
  Call<TypeCollection<ExternalVolumeEvent>> listExternalVolumeEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/externalVolumeEvents')
  Call<TypeCollection<ExternalVolumeEvent>> queryExternalVolumeEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/externalVolumeEvents/{id}')
  Call<ExternalVolumeEvent> findExternalVolumeEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/externalVolumeEvents/{id}?action=remove')
  Call<ExternalEvent> removeExternalVolumeEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/fieldDocumentations/{id}')
  Call<FieldDocumentation> findFieldDocumentationById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/genericObjects')
  Call<TypeCollection<GenericObject>> listGenericObjects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/genericObjects')
  Call<TypeCollection<GenericObject>> queryGenericObjects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/genericObjects')
  Call<GenericObject> createGenericObject(@Path('projectId') String projectId, @Body GenericObject genericObject)

  @GET('v2-beta/projects/{projectId}/genericObjects/{id}')
  Call<GenericObject> findGenericObjectById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/genericObjects/{id}')
  Call<GenericObject> updateGenericObject(@Path('projectId') String projectId, @Path('id') String id, @Body GenericObject genericObject)

  @DELETE('v2-beta/projects/{projectId}/genericObjects/{id}')
  Call<GenericObject> deleteGenericObject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/genericObjects/{id}?action=remove')
  Call<GenericObject> removeGenericObject(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMaps')
  Call<TypeCollection<HealthcheckInstanceHostMap>> listHealthcheckInstanceHostMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMaps')
  Call<TypeCollection<HealthcheckInstanceHostMap>> queryHealthcheckInstanceHostMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/healthcheckInstanceHostMaps/{id}')
  Call<HealthcheckInstanceHostMap> findHealthcheckInstanceHostMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/healthcheckInstanceHostMaps/{id}?action=remove')
  Call<HealthcheckInstanceHostMap> removeHealthcheckInstanceHostMap(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/hosts')
  Call<TypeCollection<Host>> listHosts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/hosts')
  Call<TypeCollection<Host>> queryHosts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/hosts')
  Call<Host> createHost(@Path('projectId') String projectId, @Body Host host)

  @GET('v2-beta/projects/{projectId}/hosts/{id}')
  Call<Host> findHostById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/hosts/{id}')
  Call<Host> updateHost(@Path('projectId') String projectId, @Path('id') String id, @Body Host host)

  @DELETE('v2-beta/projects/{projectId}/hosts/{id}')
  Call<Host> deleteHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=evacuate')
  Call<Host> evacuateHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=provision')
  Call<Host> provisionHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=dockersocket')
  Call<HostAccess> dockersocketHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=activate')
  Call<Host> activateHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=purge')
  Call<Host> purgeHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=error')
  Call<Host> errorHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=remove')
  Call<Host> removeHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hosts/{id}?action=deactivate')
  Call<Host> deactivateHost(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/hostAccesses/{id}')
  Call<HostAccess> findHostAccessById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/hostTemplates')
  Call<TypeCollection<HostTemplate>> listHostTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/hostTemplates')
  Call<TypeCollection<HostTemplate>> queryHostTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/hostTemplates')
  Call<HostTemplate> createHostTemplate(@Path('projectId') String projectId, @Body HostTemplate hostTemplate)

  @GET('v2-beta/projects/{projectId}/hostTemplates/{id}')
  Call<HostTemplate> findHostTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/hostTemplates/{id}')
  Call<HostTemplate> updateHostTemplate(@Path('projectId') String projectId, @Path('id') String id, @Body HostTemplate hostTemplate)

  @DELETE('v2-beta/projects/{projectId}/hostTemplates/{id}')
  Call<HostTemplate> deleteHostTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/hostTemplates/{id}?action=remove')
  Call<HostTemplate> removeHostTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/identities')
  Call<TypeCollection<Identity>> listIdentities(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/identities')
  Call<TypeCollection<Identity>> queryIdentities(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/identities/{id}')
  Call<Identity> findIdentityById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/images')
  Call<TypeCollection<Image>> listImages(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/images')
  Call<TypeCollection<Image>> queryImages(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/images/{id}')
  Call<Image> findImageById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/images/{id}?action=activate')
  Call<Image> activateImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/images/{id}?action=purge')
  Call<Image> purgeImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/images/{id}?action=remove')
  Call<Image> removeImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/images/{id}?action=deactivate')
  Call<Image> deactivateImage(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/inServiceUpgradeStrategys')
  Call<InServiceUpgradeStrategy> createInServiceUpgradeStrategy(@Path('projectId') String projectId, @Body InServiceUpgradeStrategy inServiceUpgradeStrategy)

  @GET('v2-beta/projects/{projectId}/inServiceUpgradeStrategys/{id}')
  Call<InServiceUpgradeStrategy> findInServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instances')
  Call<TypeCollection<Instance>> listInstances(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/instances')
  Call<TypeCollection<Instance>> queryInstances(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/instances/{id}')
  Call<Instance> findInstanceById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=console')
  Call<InstanceConsole> consoleInstance(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=restart')
  Call<Instance> restartInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=deallocate')
  Call<Instance> deallocateInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=start')
  Call<Instance> startInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=purge')
  Call<Instance> purgeInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=error')
  Call<Instance> errorInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=remove')
  Call<Instance> removeInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=stop')
  Call<Instance> stopInstance(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=allocate')
  Call<Instance> allocateInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=updatehealthy')
  Call<Instance> updatehealthyInstance(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instances/{id}?action=migrate')
  Call<Instance> migrateInstance(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instanceConsoles/{id}')
  Call<InstanceConsole> findInstanceConsoleById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instanceConsoleInputs/{id}')
  Call<InstanceConsoleInput> findInstanceConsoleInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceHealthChecks')
  Call<InstanceHealthCheck> createInstanceHealthCheck(@Path('projectId') String projectId, @Body InstanceHealthCheck instanceHealthCheck)

  @GET('v2-beta/projects/{projectId}/instanceHealthChecks/{id}')
  Call<InstanceHealthCheck> findInstanceHealthCheckById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/instanceLinks')
  Call<TypeCollection<InstanceLink>> listInstanceLinks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/instanceLinks')
  Call<TypeCollection<InstanceLink>> queryInstanceLinks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/instanceLinks/{id}')
  Call<InstanceLink> findInstanceLinkById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/instanceLinks/{id}')
  Call<InstanceLink> updateInstanceLink(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceLink instanceLink)

  @POST('v2-beta/projects/{projectId}/instanceLinks/{id}?action=activate')
  Call<InstanceLink> activateInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLinks/{id}?action=purge')
  Call<InstanceLink> purgeInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLinks/{id}?action=remove')
  Call<InstanceLink> removeInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceLinks/{id}?action=deactivate')
  Call<InstanceLink> deactivateInstanceLink(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/instanceStops')
  Call<InstanceStop> createInstanceStop(@Path('projectId') String projectId, @Body InstanceStop instanceStop)

  @GET('v2-beta/projects/{projectId}/instanceStops/{id}')
  Call<InstanceStop> findInstanceStopById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/ipAddresses')
  Call<TypeCollection<IpAddress>> listIpAddresses(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/ipAddresses')
  Call<TypeCollection<IpAddress>> queryIpAddresses(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/ipAddresses/{id}')
  Call<IpAddress> findIpAddressById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=activate')
  Call<IpAddress> activateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=purge')
  Call<IpAddress> purgeIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=remove')
  Call<IpAddress> removeIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=associate')
  Call<IpAddress> associateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=deactivate')
  Call<IpAddress> deactivateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ipAddresses/{id}?action=disassociate')
  Call<IpAddress> disassociateIpAddress(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/kubernetesServices')
  Call<TypeCollection<KubernetesService>> listKubernetesServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/kubernetesServices')
  Call<TypeCollection<KubernetesService>> queryKubernetesServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/kubernetesServices/{id}')
  Call<KubernetesService> findKubernetesServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=rollback')
  Call<Service> rollbackKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=upgrade')
  Call<Service> upgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=restart')
  Call<Service> restartKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=remove')
  Call<Service> removeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=deactivate')
  Call<Service> deactivateKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=removeservicelink')
  Call<Service> removeservicelinkKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=activate')
  Call<Service> activateKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=addservicelink')
  Call<Service> addservicelinkKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeKubernetesService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesServices/{id}?action=setservicelinks')
  Call<Service> setservicelinksKubernetesService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/kubernetesStacks')
  Call<TypeCollection<KubernetesStack>> listKubernetesStacks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/kubernetesStacks')
  Call<TypeCollection<KubernetesStack>> queryKubernetesStacks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks')
  Call<KubernetesStack> createKubernetesStack(@Path('projectId') String projectId, @Body KubernetesStack kubernetesStack)

  @GET('v2-beta/projects/{projectId}/kubernetesStacks/{id}')
  Call<KubernetesStack> findKubernetesStackById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/kubernetesStacks/{id}')
  Call<KubernetesStack> updateKubernetesStack(@Path('projectId') String projectId, @Path('id') String id, @Body KubernetesStack kubernetesStack)

  @DELETE('v2-beta/projects/{projectId}/kubernetesStacks/{id}')
  Call<KubernetesStack> deleteKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=rollback')
  Call<Stack> rollbackKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=upgrade')
  Call<KubernetesStack> upgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id, @Body KubernetesStackUpgrade kubernetesStackUpgrade)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=error')
  Call<Stack> errorKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=remove')
  Call<Stack> removeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStacks/{id}?action=finishupgrade')
  Call<Stack> finishupgradeKubernetesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/kubernetesStackUpgrades')
  Call<KubernetesStackUpgrade> createKubernetesStackUpgrade(@Path('projectId') String projectId, @Body KubernetesStackUpgrade kubernetesStackUpgrade)

  @GET('v2-beta/projects/{projectId}/kubernetesStackUpgrades/{id}')
  Call<KubernetesStackUpgrade> findKubernetesStackUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/labels')
  Call<TypeCollection<Label>> listLabels(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/labels')
  Call<TypeCollection<Label>> queryLabels(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/labels/{id}')
  Call<Label> findLabelById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/labels/{id}?action=remove')
  Call<Label> removeLabel(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs')
  Call<LaunchConfig> createLaunchConfig(@Path('projectId') String projectId, @Body LaunchConfig launchConfig)

  @GET('v2-beta/projects/{projectId}/launchConfigs/{id}')
  Call<LaunchConfig> findLaunchConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/launchConfigs/{id}')
  Call<LaunchConfig> updateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body LaunchConfig launchConfig)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=console')
  Call<InstanceConsole> consoleLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=restart')
  Call<Instance> restartLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=deallocate')
  Call<Instance> deallocateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=start')
  Call<Instance> startLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=purge')
  Call<Instance> purgeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=error')
  Call<Instance> errorLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=remove')
  Call<Instance> removeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=stop')
  Call<Instance> stopLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=allocate')
  Call<Instance> allocateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=updatehealthy')
  Call<Instance> updatehealthyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=migrate')
  Call<Instance> migrateLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=execute')
  Call<HostAccess> executeLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/launchConfigs/{id}?action=proxy')
  Call<HostAccess> proxyLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @POST('v2-beta/projects/{projectId}/lbConfigs')
  Call<LbConfig> createLbConfig(@Path('projectId') String projectId, @Body LbConfig lbConfig)

  @GET('v2-beta/projects/{projectId}/lbConfigs/{id}')
  Call<LbConfig> findLbConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/lbTargetConfigs/{id}')
  Call<LbTargetConfig> findLbTargetConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicys')
  Call<LoadBalancerCookieStickinessPolicy> createLoadBalancerCookieStickinessPolicy(@Path('projectId') String projectId, @Body LoadBalancerCookieStickinessPolicy loadBalancerCookieStickinessPolicy)

  @GET('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicys/{id}')
  Call<LoadBalancerCookieStickinessPolicy> findLoadBalancerCookieStickinessPolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/loadBalancerCookieStickinessPolicys/{id}')
  Call<LoadBalancerCookieStickinessPolicy> updateLoadBalancerCookieStickinessPolicy(@Path('projectId') String projectId, @Path('id') String id, @Body LoadBalancerCookieStickinessPolicy loadBalancerCookieStickinessPolicy)

  @GET('v2-beta/projects/{projectId}/loadBalancerServices')
  Call<TypeCollection<LoadBalancerService>> listLoadBalancerServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/loadBalancerServices')
  Call<TypeCollection<LoadBalancerService>> queryLoadBalancerServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices')
  Call<LoadBalancerService> createLoadBalancerService(@Path('projectId') String projectId, @Body LoadBalancerService loadBalancerService)

  @GET('v2-beta/projects/{projectId}/loadBalancerServices/{id}')
  Call<LoadBalancerService> findLoadBalancerServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/loadBalancerServices/{id}')
  Call<LoadBalancerService> updateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body LoadBalancerService loadBalancerService)

  @DELETE('v2-beta/projects/{projectId}/loadBalancerServices/{id}')
  Call<LoadBalancerService> deleteLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=rollback')
  Call<Service> rollbackLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=upgrade')
  Call<Service> upgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=restart')
  Call<Service> restartLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=remove')
  Call<Service> removeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=deactivate')
  Call<Service> deactivateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=removeservicelink')
  Call<Service> removeservicelinkLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=activate')
  Call<Service> activateLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=addservicelink')
  Call<Service> addservicelinkLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/loadBalancerServices/{id}?action=setservicelinks')
  Call<Service> setservicelinksLoadBalancerService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/logConfigs')
  Call<LogConfig> createLogConfig(@Path('projectId') String projectId, @Body LogConfig logConfig)

  @GET('v2-beta/projects/{projectId}/logConfigs/{id}')
  Call<LogConfig> findLogConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/machines')
  Call<TypeCollection<Machine>> listMachines(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/machines')
  Call<TypeCollection<Machine>> queryMachines(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/machines')
  Call<Machine> createMachine(@Path('projectId') String projectId, @Body Machine machine)

  @GET('v2-beta/projects/{projectId}/machines/{id}')
  Call<Machine> findMachineById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/machines/{id}')
  Call<Machine> updateMachine(@Path('projectId') String projectId, @Path('id') String id, @Body Machine machine)

  @DELETE('v2-beta/projects/{projectId}/machines/{id}')
  Call<Machine> deleteMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machines/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrapMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machines/{id}?action=error')
  Call<PhysicalHost> errorMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/machines/{id}?action=remove')
  Call<PhysicalHost> removeMachine(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/machineDrivers')
  Call<TypeCollection<MachineDriver>> listMachineDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/machineDrivers')
  Call<TypeCollection<MachineDriver>> queryMachineDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/machineDrivers/{id}')
  Call<MachineDriver> findMachineDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/mounts')
  Call<TypeCollection<Mount>> listMounts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/mounts')
  Call<TypeCollection<Mount>> queryMounts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/mounts/{id}')
  Call<Mount> findMountById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/mounts/{id}?action=remove')
  Call<Mount> removeMount(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/mounts/{id}?action=deactivate')
  Call<Mount> deactivateMount(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/mountEntrys/{id}')
  Call<MountEntry> findMountEntryById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/networks')
  Call<TypeCollection<Network>> listNetworks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networks')
  Call<TypeCollection<Network>> queryNetworks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/networks')
  Call<Network> createNetwork(@Path('projectId') String projectId, @Body Network network)

  @GET('v2-beta/projects/{projectId}/networks/{id}')
  Call<Network> findNetworkById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/networks/{id}')
  Call<Network> updateNetwork(@Path('projectId') String projectId, @Path('id') String id, @Body Network network)

  @DELETE('v2-beta/projects/{projectId}/networks/{id}')
  Call<Network> deleteNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networks/{id}?action=activate')
  Call<Network> activateNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networks/{id}?action=purge')
  Call<Network> purgeNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networks/{id}?action=remove')
  Call<Network> removeNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networks/{id}?action=deactivate')
  Call<Network> deactivateNetwork(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/networkDrivers')
  Call<TypeCollection<NetworkDriver>> listNetworkDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkDrivers')
  Call<TypeCollection<NetworkDriver>> queryNetworkDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/networkDrivers/{id}')
  Call<NetworkDriver> findNetworkDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDrivers/{id}?action=activate')
  Call<NetworkDriver> activateNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDrivers/{id}?action=remove')
  Call<NetworkDriver> removeNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDrivers/{id}?action=deactivate')
  Call<NetworkDriver> deactivateNetworkDriver(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/networkDriverServices')
  Call<TypeCollection<NetworkDriverService>> listNetworkDriverServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkDriverServices')
  Call<TypeCollection<NetworkDriverService>> queryNetworkDriverServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/networkDriverServices')
  Call<NetworkDriverService> createNetworkDriverService(@Path('projectId') String projectId, @Body NetworkDriverService networkDriverService)

  @GET('v2-beta/projects/{projectId}/networkDriverServices/{id}')
  Call<NetworkDriverService> findNetworkDriverServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/networkDriverServices/{id}')
  Call<NetworkDriverService> updateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body NetworkDriverService networkDriverService)

  @DELETE('v2-beta/projects/{projectId}/networkDriverServices/{id}')
  Call<NetworkDriverService> deleteNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=rollback')
  Call<Service> rollbackNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=upgrade')
  Call<Service> upgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=restart')
  Call<Service> restartNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=remove')
  Call<Service> removeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=deactivate')
  Call<Service> deactivateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=removeservicelink')
  Call<Service> removeservicelinkNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=activate')
  Call<Service> activateNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=addservicelink')
  Call<Service> addservicelinkNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkDriverServices/{id}?action=setservicelinks')
  Call<Service> setservicelinksNetworkDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/networkPolicyRules')
  Call<NetworkPolicyRule> createNetworkPolicyRule(@Path('projectId') String projectId, @Body NetworkPolicyRule networkPolicyRule)

  @GET('v2-beta/projects/{projectId}/networkPolicyRules/{id}')
  Call<NetworkPolicyRule> findNetworkPolicyRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleBetweens')
  Call<NetworkPolicyRuleBetween> createNetworkPolicyRuleBetween(@Path('projectId') String projectId, @Body NetworkPolicyRuleBetween networkPolicyRuleBetween)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleBetweens/{id}')
  Call<NetworkPolicyRuleBetween> findNetworkPolicyRuleBetweenById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleMembers')
  Call<NetworkPolicyRuleMember> createNetworkPolicyRuleMember(@Path('projectId') String projectId, @Body NetworkPolicyRuleMember networkPolicyRuleMember)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleMembers/{id}')
  Call<NetworkPolicyRuleMember> findNetworkPolicyRuleMemberById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithins')
  Call<TypeCollection<NetworkPolicyRuleWithin>> listNetworkPolicyRuleWithins(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithins')
  Call<TypeCollection<NetworkPolicyRuleWithin>> queryNetworkPolicyRuleWithins(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/networkPolicyRuleWithins')
  Call<NetworkPolicyRuleWithin> createNetworkPolicyRuleWithin(@Path('projectId') String projectId, @Body NetworkPolicyRuleWithin networkPolicyRuleWithin)

  @GET('v2-beta/projects/{projectId}/networkPolicyRuleWithins/{id}')
  Call<NetworkPolicyRuleWithin> findNetworkPolicyRuleWithinById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/nfsConfigs/{id}')
  Call<NfsConfig> findNfsConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/packetConfigs')
  Call<PacketConfig> createPacketConfig(@Path('projectId') String projectId, @Body PacketConfig packetConfig)

  @GET('v2-beta/projects/{projectId}/packetConfigs/{id}')
  Call<PacketConfig> findPacketConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/passwords')
  Call<TypeCollection<Password>> listPasswords(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/passwords')
  Call<TypeCollection<Password>> queryPasswords(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/passwords')
  Call<Password> createPassword(@Path('projectId') String projectId, @Body Password password)

  @GET('v2-beta/projects/{projectId}/passwords/{id}')
  Call<Password> findPasswordById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/passwords/{id}')
  Call<Password> updatePassword(@Path('projectId') String projectId, @Path('id') String id, @Body Password password)

  @DELETE('v2-beta/projects/{projectId}/passwords/{id}')
  Call<Password> deletePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/passwords/{id}?action=activate')
  Call<Credential> activatePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/passwords/{id}?action=purge')
  Call<Credential> purgePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/passwords/{id}?action=remove')
  Call<Credential> removePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/passwords/{id}?action=deactivate')
  Call<Credential> deactivatePassword(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/passwords/{id}?action=changesecret')
  Call<ChangeSecretInput> changesecretPassword(@Path('projectId') String projectId, @Path('id') String id, @Body ChangeSecretInput changeSecretInput)

  @GET('v2-beta/projects/{projectId}/physicalHosts')
  Call<TypeCollection<PhysicalHost>> listPhysicalHosts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/physicalHosts')
  Call<TypeCollection<PhysicalHost>> queryPhysicalHosts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/physicalHosts/{id}')
  Call<PhysicalHost> findPhysicalHostById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHosts/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrapPhysicalHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHosts/{id}?action=error')
  Call<PhysicalHost> errorPhysicalHost(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/physicalHosts/{id}?action=remove')
  Call<PhysicalHost> removePhysicalHost(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/ports')
  Call<TypeCollection<Port>> listPorts(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/ports')
  Call<TypeCollection<Port>> queryPorts(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/ports/{id}')
  Call<Port> findPortById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/ports/{id}')
  Call<Port> updatePort(@Path('projectId') String projectId, @Path('id') String id, @Body Port port)

  @POST('v2-beta/projects/{projectId}/ports/{id}?action=activate')
  Call<Port> activatePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ports/{id}?action=purge')
  Call<Port> purgePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ports/{id}?action=remove')
  Call<Port> removePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ports/{id}?action=deactivate')
  Call<Port> deactivatePort(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/portRules')
  Call<PortRule> createPortRule(@Path('projectId') String projectId, @Body PortRule portRule)

  @GET('v2-beta/projects/{projectId}/portRules/{id}')
  Call<PortRule> findPortRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/projects')
  Call<TypeCollection<Project>> listProjects(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/projects')
  Call<TypeCollection<Project>> queryProjects(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/projects/{id}')
  Call<Project> findProjectById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=upgrade')
  Call<Account> upgradeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=activate')
  Call<Account> activateProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=purge')
  Call<Account> purgeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=remove')
  Call<Account> removeProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=deactivate')
  Call<Account> deactivateProject(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projects/{id}?action=setmembers')
  Call<SetProjectMembersInput> setmembersProject(@Path('projectId') String projectId, @Path('id') String id, @Body SetProjectMembersInput setProjectMembersInput)

  @GET('v2-beta/projects/{projectId}/projectMembers')
  Call<TypeCollection<ProjectMember>> listProjectMembers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/projectMembers')
  Call<TypeCollection<ProjectMember>> queryProjectMembers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/projectMembers/{id}')
  Call<ProjectMember> findProjectMemberById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMembers/{id}?action=activate')
  Call<ProjectMember> activateProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMembers/{id}?action=purge')
  Call<ProjectMember> purgeProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMembers/{id}?action=remove')
  Call<ProjectMember> removeProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectMembers/{id}?action=deactivate')
  Call<ProjectMember> deactivateProjectMember(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/projectTemplates')
  Call<TypeCollection<ProjectTemplate>> listProjectTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/projectTemplates')
  Call<TypeCollection<ProjectTemplate>> queryProjectTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/projectTemplates/{id}')
  Call<ProjectTemplate> findProjectTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/projectTemplates/{id}?action=remove')
  Call<ProjectTemplate> removeProjectTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/publicEndpoints/{id}')
  Call<PublicEndpoint> findPublicEndpointById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/pullTasks')
  Call<TypeCollection<PullTask>> listPullTasks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/pullTasks')
  Call<TypeCollection<PullTask>> queryPullTasks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/pullTasks')
  Call<PullTask> createPullTask(@Path('projectId') String projectId, @Body PullTask pullTask)

  @GET('v2-beta/projects/{projectId}/pullTasks/{id}')
  Call<PullTask> findPullTaskById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/pullTasks/{id}?action=remove')
  Call<GenericObject> removePullTask(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/recreateOnQuorumStrategyConfigs')
  Call<RecreateOnQuorumStrategyConfig> createRecreateOnQuorumStrategyConfig(@Path('projectId') String projectId, @Body RecreateOnQuorumStrategyConfig recreateOnQuorumStrategyConfig)

  @GET('v2-beta/projects/{projectId}/recreateOnQuorumStrategyConfigs/{id}')
  Call<RecreateOnQuorumStrategyConfig> findRecreateOnQuorumStrategyConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/regions')
  Call<TypeCollection<Region>> listRegions(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/regions')
  Call<TypeCollection<Region>> queryRegions(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/regions/{id}')
  Call<Region> findRegionById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/regions/{id}?action=activate')
  Call<Region> activateRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/regions/{id}?action=purge')
  Call<Region> purgeRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/regions/{id}?action=remove')
  Call<Region> removeRegion(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/regions/{id}?action=deactivate')
  Call<Region> deactivateRegion(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/register')
  Call<TypeCollection<Register>> listRegister(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/register')
  Call<TypeCollection<Register>> queryRegister(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/register')
  Call<Register> createRegister(@Path('projectId') String projectId, @Body Register register)

  @GET('v2-beta/projects/{projectId}/register/{id}')
  Call<Register> findRegisterById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/register/{id}?action=remove')
  Call<GenericObject> removeRegister(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/register/{id}?action=stop')
  Call<Instance> stopRegister(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @GET('v2-beta/projects/{projectId}/registrationTokens')
  Call<TypeCollection<RegistrationToken>> listRegistrationTokens(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registrationTokens')
  Call<TypeCollection<RegistrationToken>> queryRegistrationTokens(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registrationTokens')
  Call<RegistrationToken> createRegistrationToken(@Path('projectId') String projectId, @Body RegistrationToken registrationToken)

  @GET('v2-beta/projects/{projectId}/registrationTokens/{id}')
  Call<RegistrationToken> findRegistrationTokenById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationTokens/{id}?action=activate')
  Call<Credential> activateRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationTokens/{id}?action=purge')
  Call<Credential> purgeRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationTokens/{id}?action=remove')
  Call<Credential> removeRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registrationTokens/{id}?action=deactivate')
  Call<Credential> deactivateRegistrationToken(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/registries')
  Call<TypeCollection<Registry>> listRegistries(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registries')
  Call<TypeCollection<Registry>> queryRegistries(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registries')
  Call<Registry> createRegistry(@Path('projectId') String projectId, @Body Registry registry)

  @GET('v2-beta/projects/{projectId}/registries/{id}')
  Call<Registry> findRegistryById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/registries/{id}')
  Call<Registry> updateRegistry(@Path('projectId') String projectId, @Path('id') String id, @Body Registry registry)

  @DELETE('v2-beta/projects/{projectId}/registries/{id}')
  Call<Registry> deleteRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registries/{id}?action=activate')
  Call<StoragePool> activateRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registries/{id}?action=purge')
  Call<StoragePool> purgeRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registries/{id}?action=remove')
  Call<StoragePool> removeRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registries/{id}?action=deactivate')
  Call<StoragePool> deactivateRegistry(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/registryCredentials')
  Call<TypeCollection<RegistryCredential>> listRegistryCredentials(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/registryCredentials')
  Call<TypeCollection<RegistryCredential>> queryRegistryCredentials(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/registryCredentials')
  Call<RegistryCredential> createRegistryCredential(@Path('projectId') String projectId, @Body RegistryCredential registryCredential)

  @GET('v2-beta/projects/{projectId}/registryCredentials/{id}')
  Call<RegistryCredential> findRegistryCredentialById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/registryCredentials/{id}')
  Call<RegistryCredential> updateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id, @Body RegistryCredential registryCredential)

  @DELETE('v2-beta/projects/{projectId}/registryCredentials/{id}')
  Call<RegistryCredential> deleteRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredentials/{id}?action=activate')
  Call<Credential> activateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredentials/{id}?action=purge')
  Call<Credential> purgeRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredentials/{id}?action=remove')
  Call<Credential> removeRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/registryCredentials/{id}?action=deactivate')
  Call<Credential> deactivateRegistryCredential(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/restartPolicys')
  Call<RestartPolicy> createRestartPolicy(@Path('projectId') String projectId, @Body RestartPolicy restartPolicy)

  @GET('v2-beta/projects/{projectId}/restartPolicys/{id}')
  Call<RestartPolicy> findRestartPolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/restoreFromBackupInputs/{id}')
  Call<RestoreFromBackupInput> findRestoreFromBackupInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/revertToSnapshotInputs/{id}')
  Call<RevertToSnapshotInput> findRevertToSnapshotInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/rollingRestartStrategys')
  Call<RollingRestartStrategy> createRollingRestartStrategy(@Path('projectId') String projectId, @Body RollingRestartStrategy rollingRestartStrategy)

  @GET('v2-beta/projects/{projectId}/rollingRestartStrategys/{id}')
  Call<RollingRestartStrategy> findRollingRestartStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/scalePolicys/{id}')
  Call<ScalePolicy> findScalePolicyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrades')
  Call<TypeCollection<ScheduledUpgrade>> listScheduledUpgrades(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrades')
  Call<TypeCollection<ScheduledUpgrade>> queryScheduledUpgrades(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/scheduledUpgrades/{id}')
  Call<ScheduledUpgrade> findScheduledUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/scheduledUpgrades/{id}?action=start')
  Call<ScheduledUpgrade> startScheduledUpgrade(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/scheduledUpgrades/{id}?action=remove')
  Call<ScheduledUpgrade> removeScheduledUpgrade(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs')
  Call<SecondaryLaunchConfig> createSecondaryLaunchConfig(@Path('projectId') String projectId, @Body SecondaryLaunchConfig secondaryLaunchConfig)

  @GET('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}')
  Call<SecondaryLaunchConfig> findSecondaryLaunchConfigById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}')
  Call<SecondaryLaunchConfig> updateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body SecondaryLaunchConfig secondaryLaunchConfig)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=console')
  Call<InstanceConsole> consoleSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=restart')
  Call<Instance> restartSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=deallocate')
  Call<Instance> deallocateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=start')
  Call<Instance> startSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=purge')
  Call<Instance> purgeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=error')
  Call<Instance> errorSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=remove')
  Call<Instance> removeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=stop')
  Call<Instance> stopSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=allocate')
  Call<Instance> allocateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=updatehealthy')
  Call<Instance> updatehealthySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=migrate')
  Call<Instance> migrateSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=execute')
  Call<HostAccess> executeSecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/secondaryLaunchConfigs/{id}?action=proxy')
  Call<HostAccess> proxySecondaryLaunchConfig(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @GET('v2-beta/projects/{projectId}/secrets')
  Call<TypeCollection<Secret>> listSecrets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/secrets')
  Call<TypeCollection<Secret>> querySecrets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/secrets')
  Call<Secret> createSecret(@Path('projectId') String projectId, @Body Secret secret)

  @GET('v2-beta/projects/{projectId}/secrets/{id}')
  Call<Secret> findSecretById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/secrets/{id}')
  Call<Secret> updateSecret(@Path('projectId') String projectId, @Path('id') String id, @Body Secret secret)

  @DELETE('v2-beta/projects/{projectId}/secrets/{id}')
  Call<Secret> deleteSecret(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secrets/{id}?action=remove')
  Call<Secret> removeSecret(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/secretReferences')
  Call<SecretReference> createSecretReference(@Path('projectId') String projectId, @Body SecretReference secretReference)

  @GET('v2-beta/projects/{projectId}/secretReferences/{id}')
  Call<SecretReference> findSecretReferenceById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/services')
  Call<TypeCollection<Service>> listServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/services')
  Call<TypeCollection<Service>> queryServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/services')
  Call<Service> createService(@Path('projectId') String projectId, @Body Service service)

  @GET('v2-beta/projects/{projectId}/services/{id}')
  Call<Service> findServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/services/{id}')
  Call<Service> updateService(@Path('projectId') String projectId, @Path('id') String id, @Body Service service)

  @DELETE('v2-beta/projects/{projectId}/services/{id}')
  Call<Service> deleteService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=rollback')
  Call<Service> rollbackService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=upgrade')
  Call<Service> upgradeService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=restart')
  Call<Service> restartService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=remove')
  Call<Service> removeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=deactivate')
  Call<Service> deactivateService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=finishupgrade')
  Call<Service> finishupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=removeservicelink')
  Call<Service> removeservicelinkService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=continueupgrade')
  Call<Service> continueupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=activate')
  Call<Service> activateService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=addservicelink')
  Call<Service> addservicelinkService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/services/{id}?action=setservicelinks')
  Call<Service> setservicelinksService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST('v2-beta/projects/{projectId}/serviceBindings')
  Call<ServiceBinding> createServiceBinding(@Path('projectId') String projectId, @Body ServiceBinding serviceBinding)

  @GET('v2-beta/projects/{projectId}/serviceBindings/{id}')
  Call<ServiceBinding> findServiceBindingById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/serviceBindings/{id}')
  Call<ServiceBinding> updateServiceBinding(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceBinding serviceBinding)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMaps')
  Call<TypeCollection<ServiceConsumeMap>> listServiceConsumeMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMaps')
  Call<TypeCollection<ServiceConsumeMap>> queryServiceConsumeMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceConsumeMaps/{id}')
  Call<ServiceConsumeMap> findServiceConsumeMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceConsumeMaps/{id}?action=remove')
  Call<ServiceConsumeMap> removeServiceConsumeMap(@Path('projectId') String projectId, @Path('id') String id)


  @GET('v2-beta/projects/{projectId}/serviceEvents')
  Call<TypeCollection<ServiceEvent>> listServiceEvents(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceEvents')
  Call<TypeCollection<ServiceEvent>> queryServiceEvents(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceEvents/{id}')
  Call<ServiceEvent> findServiceEventById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceEvents/{id}?action=remove')
  Call<ServiceEvent> removeServiceEvent(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceExposeMaps')
  Call<TypeCollection<ServiceExposeMap>> listServiceExposeMaps(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceExposeMaps')
  Call<TypeCollection<ServiceExposeMap>> queryServiceExposeMaps(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceExposeMaps/{id}')
  Call<ServiceExposeMap> findServiceExposeMapById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceExposeMaps/{id}?action=remove')
  Call<ServiceExposeMap> removeServiceExposeMap(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceLinks')
  Call<ServiceLink> createServiceLink(@Path('projectId') String projectId, @Body ServiceLink serviceLink)

  @GET('v2-beta/projects/{projectId}/serviceLinks/{id}')
  Call<ServiceLink> findServiceLinkById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceLogs')
  Call<TypeCollection<ServiceLog>> listServiceLogs(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceLogs')
  Call<TypeCollection<ServiceLog>> queryServiceLogs(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/serviceLogs/{id}')
  Call<ServiceLog> findServiceLogById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceProxies')
  Call<TypeCollection<ServiceProxy>> listServiceProxies(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/serviceProxies')
  Call<TypeCollection<ServiceProxy>> queryServiceProxies(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/serviceProxies')
  Call<ServiceProxy> createServiceProxy(@Path('projectId') String projectId, @Body ServiceProxy serviceProxy)

  @GET('v2-beta/projects/{projectId}/serviceProxies/{id}')
  Call<ServiceProxy> findServiceProxyById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceRestarts')
  Call<ServiceRestart> createServiceRestart(@Path('projectId') String projectId, @Body ServiceRestart serviceRestart)

  @GET('v2-beta/projects/{projectId}/serviceRestarts/{id}')
  Call<ServiceRestart> findServiceRestartById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/serviceUpgrades')
  Call<ServiceUpgrade> createServiceUpgrade(@Path('projectId') String projectId, @Body ServiceUpgrade serviceUpgrade)

  @GET('v2-beta/projects/{projectId}/serviceUpgrades/{id}')
  Call<ServiceUpgrade> findServiceUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/serviceUpgradeStrategys/{id}')
  Call<ServiceUpgradeStrategy> findServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/servicesPortRanges')
  Call<ServicesPortRange> createServicesPortRange(@Path('projectId') String projectId, @Body ServicesPortRange servicesPortRange)

  @GET('v2-beta/projects/{projectId}/servicesPortRanges/{id}')
  Call<ServicesPortRange> findServicesPortRangeById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/servicesPortRanges/{id}')
  Call<ServicesPortRange> updateServicesPortRange(@Path('projectId') String projectId, @Path('id') String id, @Body ServicesPortRange servicesPortRange)

  @POST('v2-beta/projects/{projectId}/setProjectMembersInputs')
  Call<SetProjectMembersInput> createSetProjectMembersInput(@Path('projectId') String projectId, @Body SetProjectMembersInput setProjectMembersInput)

  @GET('v2-beta/projects/{projectId}/setProjectMembersInputs/{id}')
  Call<SetProjectMembersInput> findSetProjectMembersInputById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/setServiceLinksInputs')
  Call<SetServiceLinksInput> createSetServiceLinksInput(@Path('projectId') String projectId, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/setServiceLinksInputs/{id}')
  Call<SetServiceLinksInput> findSetServiceLinksInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/settings')
  Call<TypeCollection<Setting>> listSettings(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/settings')
  Call<TypeCollection<Setting>> querySettings(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/settings/{id}')
  Call<Setting> findSettingById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/snapshots')
  Call<TypeCollection<Snapshot>> listSnapshots(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/snapshots')
  Call<TypeCollection<Snapshot>> querySnapshots(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/snapshots/{id}')
  Call<Snapshot> findSnapshotById(@Path('projectId') String projectId, @Path('id') String id)

  @DELETE('v2-beta/projects/{projectId}/snapshots/{id}')
  Call<Snapshot> deleteSnapshot(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/snapshots/{id}?action=backup')
  Call<Backup> backupSnapshot(@Path('projectId') String projectId, @Path('id') String id, @Body SnapshotBackupInput snapshotBackupInput)

  @POST('v2-beta/projects/{projectId}/snapshots/{id}?action=remove')
  Call<Snapshot> removeSnapshot(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/snapshotBackupInputs/{id}')
  Call<SnapshotBackupInput> findSnapshotBackupInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/stacks')
  Call<TypeCollection<Stack>> listStacks(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/stacks')
  Call<TypeCollection<Stack>> queryStacks(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/stacks')
  Call<Stack> createStack(@Path('projectId') String projectId, @Body Stack stack)

  @GET('v2-beta/projects/{projectId}/stacks/{id}')
  Call<Stack> findStackById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/stacks/{id}')
  Call<Stack> updateStack(@Path('projectId') String projectId, @Path('id') String id, @Body Stack stack)

  @DELETE('v2-beta/projects/{projectId}/stacks/{id}')
  Call<Stack> deleteStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=rollback')
  Call<Stack> rollbackStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=deactivateservices')
  Call<Stack> deactivateservicesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=activateservices')
  Call<Stack> activateservicesStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=upgrade')
  Call<Stack> upgradeStack(@Path('projectId') String projectId, @Path('id') String id, @Body StackUpgrade stackUpgrade)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=addoutputs')
  Call<Stack> addoutputsStack(@Path('projectId') String projectId, @Path('id') String id, @Body AddOutputsInput addOutputsInput)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=exportconfig')
  Call<ComposeConfig> exportconfigStack(@Path('projectId') String projectId, @Path('id') String id, @Body ComposeConfigInput composeConfigInput)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=error')
  Call<Stack> errorStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=cancelupgrade')
  Call<Stack> cancelupgradeStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=remove')
  Call<Stack> removeStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stacks/{id}?action=finishupgrade')
  Call<Stack> finishupgradeStack(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/stackUpgrades')
  Call<StackUpgrade> createStackUpgrade(@Path('projectId') String projectId, @Body StackUpgrade stackUpgrade)

  @GET('v2-beta/projects/{projectId}/stackUpgrades/{id}')
  Call<StackUpgrade> findStackUpgradeById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/statsAccesses/{id}')
  Call<StatsAccess> findStatsAccessById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/storageDrivers')
  Call<TypeCollection<StorageDriver>> listStorageDrivers(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storageDrivers')
  Call<TypeCollection<StorageDriver>> queryStorageDrivers(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/storageDrivers/{id}')
  Call<StorageDriver> findStorageDriverById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDrivers/{id}?action=activate')
  Call<StorageDriver> activateStorageDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDrivers/{id}?action=remove')
  Call<StorageDriver> removeStorageDriver(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDrivers/{id}?action=deactivate')
  Call<StorageDriver> deactivateStorageDriver(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/storageDriverServices')
  Call<TypeCollection<StorageDriverService>> listStorageDriverServices(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storageDriverServices')
  Call<TypeCollection<StorageDriverService>> queryStorageDriverServices(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/storageDriverServices')
  Call<StorageDriverService> createStorageDriverService(@Path('projectId') String projectId, @Body StorageDriverService storageDriverService)

  @GET('v2-beta/projects/{projectId}/storageDriverServices/{id}')
  Call<StorageDriverService> findStorageDriverServiceById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/storageDriverServices/{id}')
  Call<StorageDriverService> updateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body StorageDriverService storageDriverService)

  @DELETE('v2-beta/projects/{projectId}/storageDriverServices/{id}')
  Call<StorageDriverService> deleteStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=rollback')
  Call<Service> rollbackStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=upgrade')
  Call<Service> upgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=restart')
  Call<Service> restartStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=remove')
  Call<Service> removeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=deactivate')
  Call<Service> deactivateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=finishupgrade')
  Call<Service> finishupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=removeservicelink')
  Call<Service> removeservicelinkStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=continueupgrade')
  Call<Service> continueupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=activate')
  Call<Service> activateStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=addservicelink')
  Call<Service> addservicelinkStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgradeStorageDriverService(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storageDriverServices/{id}?action=setservicelinks')
  Call<Service> setservicelinksStorageDriverService(@Path('projectId') String projectId, @Path('id') String id, @Body SetServiceLinksInput setServiceLinksInput)

  @GET('v2-beta/projects/{projectId}/storagePools')
  Call<TypeCollection<StoragePool>> listStoragePools(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/storagePools')
  Call<TypeCollection<StoragePool>> queryStoragePools(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/storagePools/{id}')
  Call<StoragePool> findStoragePoolById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePools/{id}?action=activate')
  Call<StoragePool> activateStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePools/{id}?action=purge')
  Call<StoragePool> purgeStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePools/{id}?action=remove')
  Call<StoragePool> removeStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/storagePools/{id}?action=deactivate')
  Call<StoragePool> deactivateStoragePool(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/subnets')
  Call<TypeCollection<Subnet>> listSubnets(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/subnets')
  Call<TypeCollection<Subnet>> querySubnets(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/subnets/{id}')
  Call<Subnet> findSubnetById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnets/{id}?action=activate')
  Call<Subnet> activateSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnets/{id}?action=purge')
  Call<Subnet> purgeSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnets/{id}?action=remove')
  Call<Subnet> removeSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/subnets/{id}?action=deactivate')
  Call<Subnet> deactivateSubnet(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/targetPortRules')
  Call<TargetPortRule> createTargetPortRule(@Path('projectId') String projectId, @Body TargetPortRule targetPortRule)

  @GET('v2-beta/projects/{projectId}/targetPortRules/{id}')
  Call<TargetPortRule> findTargetPortRuleById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/toServiceUpgradeStrategys')
  Call<ToServiceUpgradeStrategy> createToServiceUpgradeStrategy(@Path('projectId') String projectId, @Body ToServiceUpgradeStrategy toServiceUpgradeStrategy)

  @GET('v2-beta/projects/{projectId}/toServiceUpgradeStrategys/{id}')
  Call<ToServiceUpgradeStrategy> findToServiceUpgradeStrategyById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/typeDocumentations')
  Call<TypeCollection<TypeDocumentation>> listTypeDocumentations(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/typeDocumentations')
  Call<TypeCollection<TypeDocumentation>> queryTypeDocumentations(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @GET('v2-beta/projects/{projectId}/typeDocumentations/{id}')
  Call<TypeDocumentation> findTypeDocumentationById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/ulimits')
  Call<Ulimit> createUlimit(@Path('projectId') String projectId, @Body Ulimit ulimit)

  @GET('v2-beta/projects/{projectId}/ulimits/{id}')
  Call<Ulimit> findUlimitById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/virtualMachines')
  Call<TypeCollection<VirtualMachine>> listVirtualMachines(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/virtualMachines')
  Call<TypeCollection<VirtualMachine>> queryVirtualMachines(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/virtualMachines')
  Call<VirtualMachine> createVirtualMachine(@Path('projectId') String projectId, @Body VirtualMachine virtualMachine)

  @GET('v2-beta/projects/{projectId}/virtualMachines/{id}')
  Call<VirtualMachine> findVirtualMachineById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/virtualMachines/{id}')
  Call<VirtualMachine> updateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body VirtualMachine virtualMachine)

  @DELETE('v2-beta/projects/{projectId}/virtualMachines/{id}')
  Call<VirtualMachine> deleteVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=console')
  Call<InstanceConsole> consoleVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=restart')
  Call<Instance> restartVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=deallocate')
  Call<Instance> deallocateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=start')
  Call<Instance> startVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializingVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=purge')
  Call<Instance> purgeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=error')
  Call<Instance> errorVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=remove')
  Call<Instance> removeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=stop')
  Call<Instance> stopVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=allocate')
  Call<Instance> allocateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=updatehealthy')
  Call<Instance> updatehealthyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=migrate')
  Call<Instance> migrateVirtualMachine(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=logs')
  Call<HostAccess> logsVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerLogs containerLogs)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=execute')
  Call<HostAccess> executeVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/projects/{projectId}/virtualMachines/{id}?action=proxy')
  Call<HostAccess> proxyVirtualMachine(@Path('projectId') String projectId, @Path('id') String id, @Body ContainerProxy containerProxy)

  @POST('v2-beta/projects/{projectId}/virtualMachineDisks')
  Call<VirtualMachineDisk> createVirtualMachineDisk(@Path('projectId') String projectId, @Body VirtualMachineDisk virtualMachineDisk)

  @GET('v2-beta/projects/{projectId}/virtualMachineDisks/{id}')
  Call<VirtualMachineDisk> findVirtualMachineDiskById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volumes')
  Call<TypeCollection<Volume>> listVolumes(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/volumes')
  Call<TypeCollection<Volume>> queryVolumes(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/volumes')
  Call<Volume> createVolume(@Path('projectId') String projectId, @Body Volume volume)

  @GET('v2-beta/projects/{projectId}/volumes/{id}')
  Call<Volume> findVolumeById(@Path('projectId') String projectId, @Path('id') String id)

  @PUT('v2-beta/projects/{projectId}/volumes/{id}')
  Call<Volume> updateVolume(@Path('projectId') String projectId, @Path('id') String id, @Body Volume volume)

  @DELETE('v2-beta/projects/{projectId}/volumes/{id}')
  Call<Volume> deleteVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=allocate')
  Call<Volume> allocateVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=restorefrombackup')
  Call<Volume> restorefrombackupVolume(@Path('projectId') String projectId, @Path('id') String id, @Body RestoreFromBackupInput restoreFromBackupInput)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=deallocate')
  Call<Volume> deallocateVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=purge')
  Call<Volume> purgeVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=remove')
  Call<Volume> removeVolume(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=reverttosnapshot')
  Call<Volume> reverttosnapshotVolume(@Path('projectId') String projectId, @Path('id') String id, @Body RevertToSnapshotInput revertToSnapshotInput)

  @POST('v2-beta/projects/{projectId}/volumes/{id}?action=snapshot')
  Call<Snapshot> snapshotVolume(@Path('projectId') String projectId, @Path('id') String id, @Body VolumeSnapshotInput volumeSnapshotInput)

  @POST('v2-beta/projects/{projectId}/volumeActivateInputs')
  Call<VolumeActivateInput> createVolumeActivateInput(@Path('projectId') String projectId, @Body VolumeActivateInput volumeActivateInput)

  @GET('v2-beta/projects/{projectId}/volumeActivateInputs/{id}')
  Call<VolumeActivateInput> findVolumeActivateInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volumeSnapshotInputs/{id}')
  Call<VolumeSnapshotInput> findVolumeSnapshotInputById(@Path('projectId') String projectId, @Path('id') String id)

  @GET('v2-beta/projects/{projectId}/volumeTemplates')
  Call<TypeCollection<VolumeTemplate>> listVolumeTemplates(@Path('projectId') String projectId)

  @GET('v2-beta/projects/{projectId}/volumeTemplates')
  Call<TypeCollection<VolumeTemplate>> queryVolumeTemplates(@Path('projectId') String projectId, @QueryMap Map<String, String> filters)

  @POST('v2-beta/projects/{projectId}/volumeTemplates')
  Call<VolumeTemplate> createVolumeTemplate(@Path('projectId') String projectId, @Body VolumeTemplate volumeTemplate)

  @GET('v2-beta/projects/{projectId}/volumeTemplates/{id}')
  Call<VolumeTemplate> findVolumeTemplateById(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplates/{id}?action=activate')
  Call<VolumeTemplate> activateVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplates/{id}?action=purge')
  Call<VolumeTemplate> purgeVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplates/{id}?action=remove')
  Call<VolumeTemplate> removeVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)

  @POST('v2-beta/projects/{projectId}/volumeTemplates/{id}?action=deactivate')
  Call<VolumeTemplate> deactivateVolumeTemplate(@Path('projectId') String projectId, @Path('id') String id)
}
