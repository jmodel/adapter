package com.github.jmodel.adapter.impl;

import com.github.jmodel.adapter.api.Term;

public enum AdapterImplTerms implements Term {

	// Configuration
	LFS_CONFIGURATOR {
		public String toString() {
			return "LFS_CONFIGURATOR";
		}
	},

	// Cache
	JCS_CACHER {
		public String toString() {
			return "JCS_CACHER";
		}
	},

	// Integration
	INTEGRATION_CLIENT {
		public String toString() {
			return "INTEGRATION_CLIENT";
		}
	},

	// Log
	JDK_LOGGER {
		public String toString() {
			return "JDK_LOGGER";
		}
	},

	// Mapping
	JMODEL_MAPPER {
		public String toString() {
			return "JMODEL_MAPPER";
		}
	},

	// Persistence
	MYBATIS_PERSISTER {
		public String toString() {
			return "MYBATIS_PERSISTER";
		}
	},

	// Search
	ES5_REST_SEARCHER {
		public String toString() {
			return "ES5_REST_SEARCHER";
		}
	},
	ES5_HOST {
		public String toString() {
			return "ES5_HOST";
		}
	},

	// Validation
	MODEL_VALIDATOR {
		public String toString() {
			return "MODEL_VALIDATOR";
		}
	}

}
