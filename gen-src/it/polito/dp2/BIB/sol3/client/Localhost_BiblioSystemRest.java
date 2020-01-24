
package it.polito.dp2.BIB.sol3.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.uri.UriTemplate;

@Generated(value = {
    "wadl|http://localhost:8080/BiblioSystem/rest/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2020-01-24T19:40:22.422+01:00")
public class Localhost_BiblioSystemRest {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:8080/BiblioSystem/rest/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Localhost_BiblioSystemRest.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Localhost_BiblioSystemRest.Biblio biblio(Client client, URI baseURI) {
        return new Localhost_BiblioSystemRest.Biblio(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static Client createClientInstance(ClientConfig cc) {
        return Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static Localhost_BiblioSystemRest.Biblio biblio() {
        return biblio(createClient(), BASE_URI);
    }

    public static Localhost_BiblioSystemRest.Biblio biblio(Client client) {
        return biblio(client, BASE_URI);
    }

    public static Localhost_BiblioSystemRest.Root root(Client client, URI baseURI) {
        return new Localhost_BiblioSystemRest.Root(client, baseURI);
    }

    public static Localhost_BiblioSystemRest.Root root() {
        return root(createClient(), BASE_URI);
    }

    public static Localhost_BiblioSystemRest.Root root(Client client) {
        return root(client, BASE_URI);
    }

    public static class Biblio {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Biblio(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Biblio(Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/biblio");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public Object getAsObjectXml() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(Object.class);
        }

        public<T >T getAsXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (!ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public Object getAsObjectJson() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(Object.class);
        }

        public<T >T getAsJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            if (!ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public Localhost_BiblioSystemRest.Biblio.Items items() {
            return new Localhost_BiblioSystemRest.Biblio.Items(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsArticles itemsArticles() {
            return new Localhost_BiblioSystemRest.Biblio.ItemsArticles(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsBooks itemsBooks() {
            return new Localhost_BiblioSystemRest.Biblio.ItemsBooks(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsId itemsId(String id) {
            return new Localhost_BiblioSystemRest.Biblio.ItemsId(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), id);
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsIdCitedBy itemsIdCitedBy(String id) {
            return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitedBy(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), id);
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTargets itemsIdCitationsTargets(String id) {
            return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTargets(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), id);
        }

        public Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid itemsIdCitationsTid(String id, String tid) {
            return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), id, tid);
        }

        public Localhost_BiblioSystemRest.Biblio.Shelves shelves() {
            return new Localhost_BiblioSystemRest.Biblio.Shelves(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidReads shelvesShelfidReads(String shelfid) {
            return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidReads(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), shelfid);
        }

        public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItems shelvesShelfidItems(String shelfid) {
            return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItems(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), shelfid);
        }

        public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId shelvesShelfidItemsId(String shelfid, String id) {
            return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), shelfid, id);
        }

        public static class Items {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Items(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Items(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postXml(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postXml(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postJson(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postJson(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsArticles {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsArticles(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsArticles(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/articles");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsBooks {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsBooks(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsBooks(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/books");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String keyword, Integer beforeinclusive, Integer afterinclusive, Integer page, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                if (beforeinclusive == null) {
                }
                if (beforeinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", beforeinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("beforeInclusive", ((Object[]) null));
                }
                if (afterinclusive == null) {
                }
                if (afterinclusive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", afterinclusive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("afterInclusive", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsId {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsId(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsId(Client client, URI baseUri, String id) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/{id}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("id", id);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ItemsId(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/items/{id}");
                } else {
                    template.append("biblio/items/{id}");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get id
             * 
             */
            public String getId() {
                return ((String) _templateAndMatrixParameterValues.get("id"));
            }

            /**
             * Duplicate state and set id
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ItemsId setId(String id) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("id", id);
                return new Localhost_BiblioSystemRest.Biblio.ItemsId(_client, copyUriBuilder, copyMap);
            }

            public Item putXmlAsItem(Item input) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T putXml(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putXml(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public Item putJsonAsItem(Item input) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T putJson(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putJson(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ClientResponse delete() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                return response;
            }

            public<T >T delete(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T delete(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public Item getAsItemXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public Item getAsItemJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsIdCitationsTargets {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsIdCitationsTargets(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsIdCitationsTargets(Client client, URI baseUri, String id) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/{id}/citations/targets");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("id", id);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ItemsIdCitationsTargets(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/items/{id}/citations/targets");
                } else {
                    template.append("biblio/items/{id}/citations/targets");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get id
             * 
             */
            public String getId() {
                return ((String) _templateAndMatrixParameterValues.get("id"));
            }

            /**
             * Duplicate state and set id
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTargets setId(String id) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("id", id);
                return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTargets(_client, copyUriBuilder, copyMap);
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsIdCitationsTid {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsIdCitationsTid(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsIdCitationsTid(Client client, URI baseUri, String id, String tid) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/{id}/citations/{tid}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("id", id);
                _templateAndMatrixParameterValues.put("tid", tid);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ItemsIdCitationsTid(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/items/{id}/citations/{tid}");
                } else {
                    template.append("biblio/items/{id}/citations/{tid}");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get id
             * 
             */
            public String getId() {
                return ((String) _templateAndMatrixParameterValues.get("id"));
            }

            /**
             * Duplicate state and set id
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid setId(String id) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("id", id);
                return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid(_client, copyUriBuilder, copyMap);
            }

            /**
             * Get tid
             * 
             */
            public String getTid() {
                return ((String) _templateAndMatrixParameterValues.get("tid"));
            }

            /**
             * Duplicate state and set tid
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid setTid(String tid) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("tid", tid);
                return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitationsTid(_client, copyUriBuilder, copyMap);
            }

            public Citation getAsCitationXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Citation.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public Citation getAsCitationJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Citation.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putXml(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putXml(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putJson(Object input, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putJson(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                resourceBuilder = resourceBuilder.type("application/json");
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class, input);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ClientResponse delete() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                return response;
            }

            public<T >T delete(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T delete(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ItemsIdCitedBy {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ItemsIdCitedBy(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ItemsIdCitedBy(Client client, URI baseUri, String id) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/items/{id}/citedBy");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("id", id);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ItemsIdCitedBy(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/items/{id}/citedBy");
                } else {
                    template.append("biblio/items/{id}/citedBy");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get id
             * 
             */
            public String getId() {
                return ((String) _templateAndMatrixParameterValues.get("id"));
            }

            /**
             * Duplicate state and set id
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ItemsIdCitedBy setId(String id) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("id", id);
                return new Localhost_BiblioSystemRest.Biblio.ItemsIdCitedBy(_client, copyUriBuilder, copyMap);
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public it.polito.dp2.BIB.sol3.client.Items getAsItemsJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(it.polito.dp2.BIB.sol3.client.Items.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class Shelves {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Shelves(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Shelves(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/shelves");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ClientResponse delete() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                return response;
            }

            public<T >T delete(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T delete(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ClientResponse delete(String name) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                return response;
            }

            public<T >T delete(String name, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T delete(String name, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsXml(String keyword, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(String keyword, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsJson(String keyword, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String keyword, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (keyword == null) {
                }
                if (keyword!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", keyword);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("keyword", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public MyBookshelfType postAsMyBookshelfTypeXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(MyBookshelfType.class);
            }

            public<T >T postAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public MyBookshelfType postAsMyBookshelfTypeXml(String name) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(MyBookshelfType.class);
            }

            public<T >T postAsXml(String name, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsXml(String name, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public MyBookshelfType postAsMyBookshelfTypeJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(MyBookshelfType.class);
            }

            public<T >T postAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public MyBookshelfType postAsMyBookshelfTypeJson(String name) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(MyBookshelfType.class);
            }

            public<T >T postAsJson(String name, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(String name, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("POST", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ShelvesShelfidItems {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ShelvesShelfidItems(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ShelvesShelfidItems(Client client, URI baseUri, String shelfid) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/shelves/{shelfid}/items");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("shelfid", shelfid);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ShelvesShelfidItems(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/shelves/{shelfid}/items");
                } else {
                    template.append("biblio/shelves/{shelfid}/items");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get shelfid
             * 
             */
            public String getShelfid() {
                return ((String) _templateAndMatrixParameterValues.get("shelfid"));
            }

            /**
             * Duplicate state and set shelfid
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItems setShelfid(String shelfid) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("shelfid", shelfid);
                return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItems(_client, copyUriBuilder, copyMap);
            }

            public Item getAsItemXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T getAsXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public Item getAsItemJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Item.class);
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ClientResponse put() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class);
                return response;
            }

            public<T >T put(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T put(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("PUT", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ShelvesShelfidItemsId {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ShelvesShelfidItemsId(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ShelvesShelfidItemsId(Client client, URI baseUri, String shelfid, String id) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/shelves/{shelfid}/items/{id}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("shelfid", shelfid);
                _templateAndMatrixParameterValues.put("id", id);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ShelvesShelfidItemsId(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/shelves/{shelfid}/items/{id}");
                } else {
                    template.append("biblio/shelves/{shelfid}/items/{id}");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get shelfid
             * 
             */
            public String getShelfid() {
                return ((String) _templateAndMatrixParameterValues.get("shelfid"));
            }

            /**
             * Duplicate state and set shelfid
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId setShelfid(String shelfid) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("shelfid", shelfid);
                return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId(_client, copyUriBuilder, copyMap);
            }

            /**
             * Get id
             * 
             */
            public String getId() {
                return ((String) _templateAndMatrixParameterValues.get("id"));
            }

            /**
             * Duplicate state and set id
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId setId(String id) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("id", id);
                return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidItemsId(_client, copyUriBuilder, copyMap);
            }

            public ClientResponse delete() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                return response;
            }

            public<T >T delete(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T delete(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                ClientResponse response;
                response = resourceBuilder.method("DELETE", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class ShelvesShelfidReads {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private ShelvesShelfidReads(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public ShelvesShelfidReads(Client client, URI baseUri, String shelfid) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/shelves/{shelfid}/reads");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("shelfid", shelfid);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public ShelvesShelfidReads(Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/biblio/shelves/{shelfid}/reads");
                } else {
                    template.append("biblio/shelves/{shelfid}/reads");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get shelfid
             * 
             */
            public String getShelfid() {
                return ((String) _templateAndMatrixParameterValues.get("shelfid"));
            }

            /**
             * Duplicate state and set shelfid
             * 
             */
            public Localhost_BiblioSystemRest.Biblio.ShelvesShelfidReads setShelfid(String shelfid) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("shelfid", shelfid);
                return new Localhost_BiblioSystemRest.Biblio.ShelvesShelfidReads(_client, copyUriBuilder, copyMap);
            }

            public<T >T getAsTextPlain(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("text/plain");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsTextPlain(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("text/plain");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Root {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Root(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Root(Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public Localhost_BiblioSystemRest.Root.SwaggerJson swaggerJson() {
            return new Localhost_BiblioSystemRest.Root.SwaggerJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost_BiblioSystemRest.Root.SwaggerYaml swaggerYaml() {
            return new Localhost_BiblioSystemRest.Root.SwaggerYaml(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class SwaggerJson {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private SwaggerJson(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public SwaggerJson(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/swagger.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public<T >T getAsJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class SwaggerYaml {

            private Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private SwaggerYaml(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public SwaggerYaml(Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/swagger.yaml");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public<T >T getAsYaml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/yaml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsYaml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/yaml");
                ClientResponse response;
                response = resourceBuilder.method("GET", ClientResponse.class);
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_BiblioSystemRest.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
