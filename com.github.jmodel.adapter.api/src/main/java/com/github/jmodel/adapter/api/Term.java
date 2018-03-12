package com.github.jmodel.adapter.api;

/**
 * Term is another important concept as Facade. Whatever you want to do, a
 * common language is neccessary for all stakeholders. For example, if Facade
 * concept is adopted, common feature expert and business logic coder have to
 * align their understanding about common feature. Business logic coder want to
 * log message via JDK Logger, then common feature expert provide JDK Logger
 * implementation for him. JDK Logger is a term between them. Of course,
 * business logic coder do not need to know the details of how.
 * <p>
 * It is compulsory to use Term concept for the applications based on jmodel
 * adapter framework.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface Term {

}
