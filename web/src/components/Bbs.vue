<template>
  <div>
    <h1>{{ msg }}</h1>
    <form>
      <div class="input_area">
        <input v-model="name" placeholder="お名前"/>
      </div>
      <div class="input_area">
        <textarea type="textarea" v-model="content" placeholder="本文"></textarea>
        <div class="error_message" v-if="hasContentError">{{ contentErrorMessage }}</div>
      </div>
      <div class="input_area">
        <button type="button" v-on:click="submit">投稿</button>
      </div>
    </form>
    <div class="container" v-for="result in results" :key="result.id">
      <div class="item_name">
        No.{{result.id}} {{ result.name }} ({{ result.datetime }})
        <button type="button" v-on:click="deleteContent(result.id)">削除</button>
      </div>
      <div class="item_content">{{ result.content }}</div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Bbs',
  data() {
    return {
      name: '',
      content: '',
      hasContentError: false,
      contentErrorMessage: '',
      results: []
    }
  },
  props: {
    msg: String
  },
  mounted () {
    this.getList()
  },
  methods: {
    getList: function() {
      axios.get('http://localhost:8080/bbs')
        .then(response => {
          this.results = response.data
          this.hasContentError = false
        })
    },
    submit: function() {
      axios.post('http://localhost:8080/bbs', {
        name: this.name === '' ? '名無しさん' : this.name,
        content: this.content
      }).then(response => {
        this.content = ''
        this.getList()
      }).catch(error => {
        this.hasContentError = true
        this.contentErrorMessage = error.response.data.message
      })
    },
    deleteContent: function(id) {
      axios.delete('http://localhost:8080/bbs/' + id)
      .then(response => {
        this.getList()
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.input_area input {
  width: 500px;
  margin-bottom: 5px;
  border: 1px solid;
  border-radius: 0.67em;
  padding: 0.5em;
}
.input_area .error_message {
  color: red;
}
.input_area textarea {
  width: 500px;
  height: 80px;
  border: 1px solid;
  border-radius: 0.67em;
  padding: 0.5em;
}
.input_area button {
  width: 200px;
  border: 1px solid;
  border-radius: 0.67em;
}
.container {
  margin: 20px;
  background: #e1e5e7;
  border-radius: 0.67em;
  padding: 0.5em;
}
.container .item_name {
  color: gray;
}
.container .item_content {
  white-space: pre-wrap;
}
</style>
