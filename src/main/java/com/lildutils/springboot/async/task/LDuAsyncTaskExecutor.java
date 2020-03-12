package com.lildutils.springboot.async.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SuppressWarnings("serial")
public class LDuAsyncTaskExecutor extends SimpleAsyncTaskExecutor
{
	private static final Logger LOGGER = LoggerFactory.getLogger( LDuAsyncTaskExecutor.class );

	public LDuAsyncTaskExecutor( String taskPrefix )
	{
		super( taskPrefix );
	}

	@Override
	protected void doExecute( Runnable task )
	{
		if( LOGGER.isInfoEnabled() )
		{
			LOGGER.info( "[ASYNC] [INFO] Running: " + task.getClass().toString() );
		}
		super.doExecute( task );
	}

}
