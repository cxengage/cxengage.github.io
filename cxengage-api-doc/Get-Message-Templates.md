## Message Template Resources

```
  GET instance/:iid/message_templates
```

## Description

Retrieves message templates for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET instance/IN1/message_template
```

```json
[
    {
        "id": "MT1",
        "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs. Gelson Bank.",
        "description": "Default SMS message with click-to-call",
        "name": "SMS"
    },
    {
        "id": "MT2",
        "template": "Hi {{first-name}}\r\n\r\nWe apologize for the
inconvenience. Please contact us at {{email-address}} at your earliest
convenience.\r\n\r\nThank You\r\n",
        "description": "Email apologizing to customer",
        "name": "Email"
    }
]
```
