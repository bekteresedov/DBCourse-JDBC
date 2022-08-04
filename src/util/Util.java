package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Util {
	public static void close(Connection c, PreparedStatement ps, ResultSet rs) {
		try {
			if (c != null)
				c.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}}
		public static void close(Connection c, PreparedStatement ps) {
			try {
				if (c != null)
					c.close();
				if (ps != null)
					ps.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
}
