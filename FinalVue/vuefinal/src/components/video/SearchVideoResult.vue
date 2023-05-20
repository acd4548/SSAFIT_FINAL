<template>
  <div>
    <ul>
      <li v-for="(video, index) in videos" :key="index">
        <img :src="video.snippet.thumbnails.default.url" />
        {{ video.snippet.title }}
        <detail-video :video="video">상세보기</detail-video>
      </li>
    </ul>
  </div>
</template>

<script>
import DetailVideo from "@/components/video/DetailVideo.vue";
export default {
  name: "SearchVideoResult",
  props: {
    videos: Array,
  },
  components: {
    DetailVideo,
  },
  data() {
    return {
      video: {},
    };
  },
  methods: {
    CaR() {},
  },
};
</script>

<style></style>
