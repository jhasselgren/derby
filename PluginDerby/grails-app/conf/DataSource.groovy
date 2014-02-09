dataSource {
    pooled = true
    driverClassName = "org.apache.derby.jdbc.EmbeddedDriver"
	//driverClassName = "org.apache.derby.jdbc.ClientDriver"
	
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:derby:grails_dev;create=true"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:derby:grails_test;create=true"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:derby:grails_prod;create=true"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
        }
    }
}
