<template>
  <div id="map" style="width: 100%; height: 100%"></div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const planStore = "planStore";

export default {
  name: "PlanEditMap",
  data() {
    return {
      map: null,
      mapMarkers: [], // 마커를 관리하기 위한 배열
      mapLines: [],
      mapInfos: [],
      mapOverlays: [],
    };
  },
  computed: {
    ...mapState(planStore, ["routes", "markers"]),
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      script.onload = () => window.kakao.maps.load(this.initMap.bind(this)); // 수정이 필요한 부분입니다.
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAO_MAP_API_KEY}`;
      document.head.appendChild(script);
    }
  },
  watch: {
    markers: {
      deep: true,
      handler(newMarkers) {
        this.updateMarkers(newMarkers);
      },
    },
  },
  methods: {
    ...mapActions(planStore, ["setMarker"]),
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 10,
      };
      this.map = new window.kakao.maps.Map(container, options);
      // 초기 마커 표시
      this.updateMarkers(this.markers);
    },
    updateMarkers(newMarkers) {
      // 이전에 표시된 마커 제거
      this.mapMarkers.forEach((marker) => marker.setMap(null));
      this.mapMarkers = [];

      // 새로운 마커 표시
      newMarkers.forEach((markerInfo, index) => {
        const position = new window.kakao.maps.LatLng(markerInfo.lat, markerInfo.lng);
        const marker = new window.kakao.maps.Marker({ position });
        // marker.setMap(this.map);
        this.mapMarkers.push(marker);
        if (index === newMarkers.length - 1) {
          this.panTo(markerInfo.lat, markerInfo.lng);
        }
      });

      // 모든 마커를 표시한 후에 한 번에 화면에 렌더링하도록 지정
      window.kakao.maps.event.trigger(this.map, "idle");

      // 지도에 선을 표시합니다
      this.drawLine(newMarkers);
      this.drawInfoWindow(newMarkers);
    },
    panTo(lat, lng) {
      // 지도 이동
      // 이동할 위도 경도 위치를 생성합니다
      var moveLatLon = new window.kakao.maps.LatLng(lat, lng);

      // 지도 중심을 부드럽게 이동시킵니다
      // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
      this.map.panTo(moveLatLon);
    },

    drawLine(items) {
      this.mapLines.forEach((polyline) => polyline.setMap(null));
      this.mapLines = [];
      // 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
      let linePath = [];
      items.forEach((item) => {
        linePath.push(new window.kakao.maps.LatLng(item.lat, item.lng));
      });

      // 지도에 표시할 선을 생성합니다
      let polyline = new window.kakao.maps.Polyline({
        path: linePath, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#FFAE00", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });

      // 지도에 선을 표시합니다
      polyline.setMap(this.map);
      this.mapLines.push(polyline);
    },

    drawInfoWindow(items) {
      this.mapOverlays.forEach((item) => {
        item.setMap(null);
      });
      this.mapOverlays = [];

      items.forEach((item, index) => {
        let iwContent = `<div>
            <span class="marker-label">${index + 1}</span>
            <span class="marker-label">${index + 1}</span>
          </div>`,
          iwPosition = new window.kakao.maps.LatLng(item.lat, item.lng); //인포윈도우 표시 위치입니다

        // 인포윈도우를 생성합니다
        var overlay = new window.kakao.maps.CustomOverlay({
          position: iwPosition,
          content: iwContent,
        });

        // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
        overlay.setMap(this.map);
        this.mapOverlays.push(overlay);
      });
    },
  },
};
</script>

<style>
.marker-label {
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #66d49f;
  color: #ffffff;
  text-align: center;
  line-height: 20px;
  font-size: 15px;
}
</style>
