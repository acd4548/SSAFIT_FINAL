<template>
  <div>
    <h2>영상보여주는 페이지</h2>
    <search-video @search-input="search"></search-video>
    <search-video-result :videos="videos"></search-video-result>
    <!-- <ul>
      <li
        v-for="video in videos"
        :key="video.id.videoId"
        :youtubeId="video.id.videoId"
      >
        <img @click="CaR" :src="video.snippet.thumbnails.default.url" />
        {{ video.snippet.title }}
      </li>
    </ul> -->
  </div>
</template>

<script>
import SearchVideo from "@/components/video/SearchVideo.vue";
import SearchVideoResult from "@/components/video/SearchVideoResult.vue";
import axios from "axios";

export default {
  name: "VideoView",
  components: {
    SearchVideo,
    SearchVideoResult,
  },
  data() {
    return {
      //created든 수동적으로 넣든 json으로 기본 영상정보 넣어주기.
      videos: [],
    };
  },
  methods: {
    search(value) {
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;
      axios({
        url: URL,
        method: "GET",
        params: {
          key: API_KEY,
          part: "snippet",
          q: value,
          type: "video",
          maxResults: 10,
        },
      })
        .then((res) => {
          console.log(res);
          return res.data.items;
        })
        .then((res) => {
          this.videos = res;
        });
      // .catch((err) => console.log(err));
    },
  },
};
</script>

<style></style>
