package models

import play.api.db._
import play.api.Play.current
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.KeyedEntity

case class Task(id: Long, label: String) extends KeyedEntity[Long]

object Task extends Schema {
  val taskTable = table[Task]("task")

  //  def all(): IndexedSeq[Task] = DB.withConnection {
  //    implicit c =>
  //      taskTable.toIndexedSeq
  //  }

  def all(): IndexedSeq[Task] = {
    inTransaction {
      taskTable.toIndexedSeq
    }
  }

  def create(label: String) {
    inTransaction {
      taskTable.insert(Task(0, label))
    }
  }

  def delete(id: Long) {
    inTransaction {
      taskTable.deleteWhere(task => task.id === id)
    }
  }
}