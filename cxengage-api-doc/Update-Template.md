# Template Resources

```
  PUT tenants/:iid/templates/:id
```

## Description

Updates template on given tenant


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ - Selected template

### Errors

All known errors will be returned in a JSON map with key "error".


### Example


**Request**

```
  PUT tenants/tenant1/templates/TM1
  Content-Type: application/json; charset=utf-8
```

```json
  {
   
    "name": "Test Template"
  }
```

**Return**
```json
{
    "id": "TM1",
    "template": "Hi {{first-name}}\r\n\r\nWe apologize for the inconvenience. Please contact us at {{email-address}} at your earliest convenience.\r\n\r\nThank You\r\n",
    "description": "SMS apologizing to customer",
    "name": "Test Template"
}
```

```
curl -XPUT https://api.cxengage.net/1.0/tenants/{{tenant-name}}/templates/TM1 \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Test Template"}'
```
