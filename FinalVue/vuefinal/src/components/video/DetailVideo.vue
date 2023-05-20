<!-- 영상 상세 정보 화면 -->
<template>
  <div>
    <detail-video-comment></detail-video-comment>
    <!-- {{ video.id.videoId }}<br /> -->
    {{ youtubeId }}
  </div>
</template>

<script>
import DetailVideoComment from "./DetailVideoComment.vue";
import http from "@/util/http-common";

export default {
  name: "DetailVideo",
  components: {
    DetailVideoComment,
  },
  props: {
    video: Object,
  },
  data() {
    return {
      youtubeId: "",
      channelName: "",
      title: "",
    };
  },
  created() {
    this.youtubeId = this.video.id.videoId;
    this.channelName = this.video.snippet.channelTitle;
    this.title = this.video.snippet.title;
    // console.log(this.video);
    // console.log(this.video.youtubeId);
    // console.log(this.video.channelName);
    // console.log(this.video.title);
    const video = {
      channelName: this.channelName,
      title: this.title,
      viewCnt: 2,
      youtubeId: this.youtubeId,
    };
    // http.post("/video", {
    //   channelName: this.channelName,
    //   title: this.title,
    //   viewCnt: 2,
    //   youtubeId: this.youtubeId,
    // });
    http.post("/video", video);
  },
};
</script>

<style></style>
