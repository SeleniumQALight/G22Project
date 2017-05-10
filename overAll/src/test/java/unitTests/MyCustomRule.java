package unitTests;



import org.apache.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyCustomRule implements TestRule {
	private Statement base;
	private Description description;
	
	public Statement apply(Statement base, Description description) {
		this.base = base;
		this.description = description;
		return new MyStatement(base);
	}
	
	private class MyStatement extends Statement {
		Logger logger = Logger.getLogger(getClass());
		private final Statement base;
		public MyStatement(Statement base) {
			this.base = base;
		}
		
		public void evaluate() throws Throwable {
			logger.info( description.getMethodName() + " Started");
			try{
				base.evaluate();
			}finally {
				logger.info(description.getMethodName() + " Finished");
			}
		}
	}
}