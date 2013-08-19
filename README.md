cxengage.github.io
==================
# Platform API Documentation

## Account

Authenticated methods that allow you to manage your account.

Resource | Description
--- | ---
[<code>GET</code> account](account/GET.md) | Returns the authenticated user's account information
[<code>PUT</code> account](account/PUT.md) | Updates the authenticated user's account information
[<code>GET</code> account/tenants](account/GET_tenants.md) | Returns the active tenants the authenticated user has permission to access

## Tenants

Authenticated methods that allow you to get more information about a tenant.

Resource | Description
--- | ---
[<code>GET</code> tenants/:tid](tenants/GET_id.md) | Returns information for tenant `tid`
[<code>POST</code> tenants/:tid/accounts/:id](tenants/POST_tid_accounts_id.md) | Gives permission to account `id` to access the tenant `tid`
[<code>DELETE</code> tenants/:tid/accounts/:id](tenants/DELETE_tid_accounts_id.md) | Revokes permission of account `id` to access the tenant `tid`

## Event Record

Authenticated methods that allow you to manage the event record of a tenant.

Resource | Description
--- | ---
[<code>GET</code> tenants/:tid/event_record](event_record/GET.md) | Returns the event record on tenant `tid`
[<code>POST</code> tenants/:tid/event_record](event_record/POST.md) | Updates the event record for tenant `tid`

## Patterns

Authenticated methods that allow you to manage the patterns of a tenant.

Resource | Description
--- | ---
[<code>GET</code> tenants/:tid/patterns](patterns/GET.md) | Returns all patterns for tenant `tid`
[<code>POST</code> tenants/:tid/patterns](patterns/POST.md) | Creates a new pattern for tenant `tid`
[<code>GET</code> tenants/:tid/patterns/:id](patterns/GET_id.md) | Returns the pattern matching `id` for tenant `tid`
[<code>POST</code> tenants/:tid/patterns/:id](patterns/POST_id.md) | Updates the pattern matching `id` for tenant `tid`
[<code>DELETE</code> tenants/:tid/patterns/:id](patterns/DELETE_id.md) | Deletes the pattern matching `id` for tenant `tid`

## Message Templates

Authenticated methods that allow you to manage the message templates of a tenant.

Resource | Description
---| ---
[<code>GET</code> tenants/:tid/message_templates](message_templates/GET.md) | Returns all message templates for tenant `tid`
[<code>POST</code> tenants/:tid/message_templates](message_templates/POST.md) | Creates a new message template for tenant `tid`
[<code>GET</code> tenants/:tid/message_templates/:id](message_templates/GET_id.md) | Returns the message template matching `id` for tenant `tid`
[<code>POST</code> tenants/:tid/message_templates/:id](message_templates/POST_id.md) | Updates the message template matching `id` for tenant `tid`
[<code>DELETE</code> tenants/:tid/message_templates/:id](message_templates/DELETE_id.md) | Deletes the message template matching `id` for tenant `tid`

## Listeners

Authenticated methods that allow you to manage the listeners of a tenant.

Resource | Description
---| ---
[<code>GET</code> tenants/:tid/listeners](listeners/GET.md) | Returns all listeners for tenant `tid`
[<code>POST</code> tenants/:tid/listeners](listeners/POST.md) | Creates a new listener for tenant `tid`
[<code>GET</code> tenants/:tid/listeners/:id](listeners/GET_id.md) | Returns the listener matching `id` for tenant `tid`
[<code>POST</code> tenants/:tid/listeners/:id](listeners/POST_id.md) | Updates the listener matching `id` for tenant `tid`
[<code>DELETE</code> tenants/:tid/listeners/:id](listeners/DELETE_id.md) | Deletes the listener matching `id` for tenant `tid`

## Integrations

Authenticated methods that allow you to manage the integrations of a tenant.


Resource | Description
---| ---
[<code>GET</code> tenants/:tid/integrations](integrations/GET.md) | Returns all integrations for tenant `tid`
[<code>GET</code> tenants/:tid/integrations/:id](integrations/GET_id.md) | Returns the integration matching `id` for tenant `tid`
[<code>POST</code> tenants/:tid/integrations/:id](integrations/POST_id.md) | Updates the integration matching `id` for tenant `tid`

## Augments

Authenticated methods that allow you to manage the augments of a tenant.

Resource | Description
---| ---
[<code>GET</code> tenants/:tid/augments](augments/GET.md) | Returns all augments for tenant `tid`
[<code>POST</code> tenants/:tid/augments](augments/POST.md) | Creates a new augment for tenant `tid`
[<code>GET</code> tenants/:tid/augments/:id](augments/GET_id.md) | Returns the augment matching `id` for tenant `tid`
[<code>POST</code> tenants/:tid/augments/:id](augments/POST_id.md) | Updates the augment matching `id` for tenant `tid`
[<code>DELETE</code> tenants/:tid/augments/:id](augments/DELETE_id.md) | Deletes the augment matching `id` for tenant `tid`

## Reaction Search

__TBD__

## Manager 

Authenticated methods that allow you to view and delete events currently in the system.

Resource | Description
---- | ---
[<code>GET</code> tenants/:tid/manager/events/:evid](manager/GET_tenant_tid_manager_events_id.md) | Returns value of event `evid`
[<code>GET</code> tenants/:tid/manager/patterns/:ptid](manager/GET_tenant_tid_manager_patterns_id.md) | Returns the events that currently contribute to pattern `ptid` for tenant `tid`
[<code>GET</code> tenants/:tid/manager/events/key/:keyid](manager/GET_tenant_tid_manager_key_id.md) | Returns the events that match key attribute `keyid` for tenant `tid`
[<code>DELETE</code> tenants/:tid/manager/events/:evid](manager/DELETE_tenant_tid_manager_events_key_id.md) | Deletes the event matching `evid` for tenant `tid`
