package io.eels.component.jdbc

import java.sql.{Connection, PreparedStatement}

import io.eels.Part
import io.eels.component.jdbc.dialect.JdbcDialect

case object SinglePartitionStrategy extends JdbcPartitionStrategy {
  override def parts(connFn: () => Connection,
                     query: String,
                     bindFn: (PreparedStatement) => Unit,
                     fetchSize: Int,
                     dialect: JdbcDialect): List[Part] = {
    List(new JdbcPart(connFn, query, bindFn, fetchSize, dialect))
  }
}
