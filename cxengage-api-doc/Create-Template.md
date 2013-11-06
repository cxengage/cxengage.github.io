# Template Resources

```
  POST tenants/:iid/templates
```

## Description

Creates/Updates event record on given tenant


### Parameters

- **iid** _(required)_ — Selected tenant


### Errors

All known errors will be returned in a JSON map with key "error".


### Example


**Request**

```
POST /1.0/tenants/{{tenant-name}}/templates HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
  {
    "template": "Hi {{first-name}}\r\n\r\nWe apologize for the inconvenience. Please contact us at {{email-address}} at your earliest convenience.\r\n\r\nThank You\r\n",
    "description": "SMS apologizing to customer",
    "name": "SMS"
  }
```

**Return**
```json
{
    "id": "TM1",
    "template": "Hi {{first-name}}\r\n\r\nWe apologize for the inconvenience. Please contact us at {{email-address}} at your earliest convenience.\r\n\r\nThank You\r\n",
    "description": "SMS apologizing to customer",
    "name": "SMS"
}
```

### curl Example

```
curl -X POST https://api.cxengage.net/1.0/tenants/userevents/templates \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"template": "Welcome to the 4.0 version of CxEngage", "description" : "sample description", "name" : "Welcome"}'

```
