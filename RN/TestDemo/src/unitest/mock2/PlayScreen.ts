import { SoundPlayer } from "./SoundPlayer";

export class PlayScreen {
  player = new SoundPlayer();

  onPlayPressed() {
    const file = "jazz.mp3";
    this.player.play(file);
  }
}
