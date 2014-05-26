package my.ilya.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.concurrent.TimeoutException;

public class Test {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			String url = "jdbc:hsqldb:hsql://localhost";
			try {
				connection = DriverManager.getConnection(url, "ilya", "111");
			} catch (SQLTransientConnectionException e) {
				startDatabaseServer();
			}
			
		
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			// jdbc:hsqldb:hsql://localhost/mydb
			// String url =
			// "jdbc:hsqldb:file:test/c:/Soft/hsqldb-2.2.9/hsqldb/data";
			//String url = "jdbc:hsqldb:hsql://localhost/";
			connection = DriverManager.getConnection(url, "ilya", "111");
			connection.setAutoCommit(false);

			statement = connection.createStatement();

			String update1 = "UPDATE test SET name = 'i44lya' WHERE id =1";
			statement.executeUpdate(update1);
			String update = "select * from test";
			ResultSet rs = statement.executeQuery(update);
			System.err.println(rs.next());

			System.err.println(rs.getInt(1));
			System.err.println(rs.getString(2));

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
		}
	}

	private static void startDatabaseServer() {
		// РїР°СЂР°РјРµС‚СЂС‹ РґР»СЏ Р·Р°РїСѓСЃРєР°
		String cmd[] = { "cmd.exe", "/C", "start", "runServer.bat" };

		try {
			executeCommandLine(cmd, true, true, 10000L);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// // СЃСЃС‹Р»РєР° РЅР° РѕР±СЉРµРєС‚ Runtime
		// Runtime rt = Runtime.getRuntime();
		// for(String command : cmd) {
		// System.out.println("Execing: " + command);
		// }
		// // РІС‹РїРѕР»РЅСЏРµРј РєРѕРјР°РЅРґРЅСѓСЋ СЃС‚СЂРѕРєСѓ, РїРµСЂРµРґР°РЅСѓСЋ РІ РїР°СЂР°РјРµС‚СЂРµ cmd
		// try {
		// Process proc = rt.exec(cmd);
		// proc.wait();
		// System.err.println(proc.waitFor());
		// //proc.
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static int executeCommandLine(final String[] commandLine,
			final boolean printOutput, final boolean printError,
			final long timeout) throws IOException, InterruptedException,
			TimeoutException {

		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(commandLine);
		/* Set up process I/O. */

		Worker worker = new Worker(process);
		worker.start();
		try {
			worker.join(timeout);
			if (worker.exit != null)
				return worker.exit;
			else
				throw new TimeoutException();
		} catch (InterruptedException ex) {
			worker.interrupt();
			Thread.currentThread().interrupt();
			throw ex;
		} finally {
			process.destroy();
		}
	}

	private static class Worker extends Thread {
		private final Process process;
		private Integer exit;

		private Worker(Process process) {
			this.process = process;
		}

		public void run() {
			try {
				exit = process.waitFor();
			} catch (InterruptedException ignore) {
				return;
			}
		}
	}
}
