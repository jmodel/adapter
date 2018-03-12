package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.Term;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public enum AdapterTerms implements Term {

	ADAPTER {
		public String toString() {
			return "Adapter";
		}
	},

	CACHER {
		public String toString() {
			return "CacherAdapter";
		}
	},

	INTEGRATOR {
		public String toString() {
			return "IntegratorAdapter";
		}
	},

	LOGGER {
		public String toString() {
			return "LoggerAdapter";
		}
	},

	MAPPER {
		public String toString() {
			return "MapperAdapter";
		}
	},

	PERSISTER {
		public String toString() {
			return "PersisterAdapter";
		}
	},

	// Searcher Adapter
	SEARCHER {
		public String toString() {
			return "SearcherAdapter";
		}
	},

	VALIDATOR {
		public String toString() {
			return "ValidatorAdapter";
		}
	}

}
