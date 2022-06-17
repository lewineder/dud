package dud
package model
package fileIO_component

import game_component.GameInterface


trait FileIOInterface {
  
  def load: GameInterface
  def save(game: GameInterface): Unit
}